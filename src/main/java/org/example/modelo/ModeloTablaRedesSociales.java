package org.example.modelo;



import org.example.persistencia.RedesSocialesDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaRedesSociales implements TableModel {
    public static final int COLUMNS = 6;
    private ArrayList<RedesSociales> datos;
    private RedesSocialesDAO mtdao;

    public ModeloTablaRedesSociales() {
        mtdao = new RedesSocialesDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaRedesSociales(ArrayList<RedesSociales> datos) {
        this.datos = datos;
        mtdao = new RedesSocialesDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "AñoDeInicio";
            case 3:
                return "ColorAplicacion";
            case 4:
                return "Usuarios";
            case 5:
                return "Imagenurl";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RedesSociales tmp = datos.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> tmp.getId();
            case 1 -> tmp.getNombre();
            case 2 -> tmp.getAnioDeInicio();
            case 3 -> tmp.getColorAplicacion();
            case 4 -> tmp.getUsuarios();
            case 5 -> tmp.getImagenUrl();
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).setId();
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setAnioDeInicio((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setColorAplicacion((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setUsuarios((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setImagenurl((String) aValue);
                break;
            default:
                System.out.println("No se necesita modificar nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    //Metodo que se invoca en el controlador para boton cargar:
    public void cargarDatos(){
        try {
            ArrayList tirar = mtdao.obtenerTodo();
            System.out.println(tirar);
            datos = mtdao.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }

    //Metodo que se invoca en el controlador para boton agregar:
    public boolean agregarRedesSociales(RedesSociales redesSociales){
        boolean resultado = false;
        try{
            if(mtdao.insertar(redesSociales)){
                datos.add(redesSociales);
                resultado = true;
            }else{
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public RedesSociales getRedesSocialesidx(int idx){
        return datos.get(idx);
    }

    //Metodo que se invoca en el controlador para boton delete:
    public boolean borrarRedesSociales(int id) {
        boolean resultado = false;
        try {
            if (mtdao. delete(id)) {
                resultado = true;
            }else{
                resultado = false;
            }
        }catch(SQLException sqle){
            System.out.println("No se pudo");
        }
        return resultado;
    }

    //Metodo que se invoca en el controlador para boton Actualizar:
    public boolean actualizarUnElemento(Object o, int id, int columna){
        boolean resultado = false;
        try {
            if (mtdao.updateUnElemento(o,id,columna)) {
                resultado = true;
            } else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println("No se pudo");
        }
        return resultado;
    }

}
