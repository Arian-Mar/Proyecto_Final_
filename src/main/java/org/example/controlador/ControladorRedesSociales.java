package org.example.controlador;

import org.example.interfaz.VentanaRedesSociales;
import org.example.modelo.ModeloTablaRedesSociales;
import org.example.modelo.RedesSociales;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorRedesSociales extends MouseAdapter {
    private VentanaRedesSociales view;
    private ModeloTablaRedesSociales modelo;

    public ControladorRedesSociales(VentanaRedesSociales view) {
        this.view = view;
        modelo = new ModeloTablaRedesSociales();
        modelo.cargarDatos();
        this.view.getTblRedesSociales().setModel(modelo);
        this.view.getTblRedesSociales().updateUI();

        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblRedesSociales().addMouseListener(this);
        this.view.getBtnDelete().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //Evento del boton cargar:
        if(e.getSource() == this.view.getBtnCargar()){
            modelo.cargarDatos();
            this.view.getTblRedesSociales().setModel(modelo);
            this.view.getTblRedesSociales().updateUI();
        }

        //Eventos del boton agregar:
        if(e.getSource() == this.view.getBtnAgregar()){
            RedesSociales redesSociales= new RedesSociales();
            redesSociales.setId(0);
            redesSociales.setNombre(this.view.getTxtNombre().getText());
            redesSociales.setAnioDeInicio(this.view.getTxtanioDeInicio().getText());
            redesSociales.setColorAplicacion(this.view.getTxtColorAplicacion().getText());
            redesSociales.setUsuarios(this.view.getTxtUsuarios().getText());
            redesSociales.setImagenUrl(this.view.getTxtUrl().getText());

            if(modelo.agregarRedesSociales(redesSociales)){
                JOptionPane.showMessageDialog(view,"Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblRedesSociales().updateUI();
            }else{
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de Datos." +
                        "Por favor revise su conexion", "Error al insertar", JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpiar();
        }

        //Eventos sobre la tabla:
        if(e.getSource() == view.getTblRedesSociales()){
            System.out.println("Evento sobre tabla");
            int index = this.view.getTblRedesSociales().getSelectedRow();
            RedesSociales tmp = modelo.getRedesSocialesidx(index);
            try{
                this.view.getImagenRedesSociales().setIcon(tmp.getImagen());
                this.view.getImagenRedesSociales().setText("");
            }catch(MalformedURLException mfue){
                System.out.println("Imagen no encontrada");
            }
        }

        //Evento del boton Delete:
        if(e.getSource() == view.getBtnDelete()){
            int index = this.view.getTblRedesSociales().getSelectedRow();
            int id = modelo.getRedesSocialesidx(index).getId();
            int respuesta = JOptionPane.showConfirmDialog(view, "¿Seguro que quieres borrar el elemento con indice: "
                    + id + "?", "Atencion", JOptionPane.YES_NO_OPTION);
            if(respuesta == 0){
                if(modelo.borrarRedesSociales(id)){
                    JOptionPane.showMessageDialog(view, "Se borro ese renglon");

                    modelo.cargarDatos();
                    this.view.getTblRedesSociales().setModel(modelo);
                    this.view.getTblRedesSociales().updateUI();
                } else{
                    JOptionPane.showMessageDialog(view, "No has cargado la tabla");
                }
            }
        }

        //Evento del boton Actualizar:
        if(e.getSource() == view.getBtnActualizar()){

            //Para actualizar cualquier casilla con dato de tipo String:
            try{
                Object o = this.view.getTxtActualizar().getText();
                int index = this.view.getTblRedesSociales().getSelectedRow();
                int id = modelo.getRedesSocialesidx(index).getId();
                int columna = this.view.getTblRedesSociales().getSelectedColumn();

                if(modelo.actualizarUnElemento(o, id, columna)){
                    JOptionPane.showMessageDialog(view, "Se actualizo ese elemento");
                    this.view.limpiar();
                    modelo.cargarDatos();
                    this.view.getTblRedesSociales().setModel(modelo);
                    this.view.getTblRedesSociales().updateUI();
                } else{
                    JOptionPane.showMessageDialog(view, "No has cargado la tabla");
                }
                //Para actualizar las casillas que poseen datos Double:
            }catch (ClassCastException cce){
                Object o = this.view.getTxtActualizar().getText();
                int index = this.view.getTblRedesSociales().getSelectedRow();
                int id = modelo.getRedesSocialesidx(index).getId();
                int columna = this.view.getTblRedesSociales().getSelectedColumn();

                if(modelo.actualizarUnElemento(o, id, columna)){
                    JOptionPane.showMessageDialog(view, "Se actualizo ese elemento");
                    modelo.cargarDatos();
                    this.view.getTblRedesSociales().setModel(modelo);
                    this.view.getTblRedesSociales().updateUI();
                } else{
                    JOptionPane.showMessageDialog(view, "No se puede modificar el id");
                }

            }

        }
    }
}
