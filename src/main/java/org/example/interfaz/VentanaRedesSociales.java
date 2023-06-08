package org.example.interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaRedesSociales extends JFrame {
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblanioDeInicio;
    private JLabel lblColorAplicacion;
    private JLabel lblUsuarios;
    private JLabel lblUrl;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtanioDeInicio;
    private JTextField txtColorAplicacion;
    private JTextField txtUsuarios;
    private JTextField txtUrl;

    private JButton btnAgregar;
    private JButton btnCargar;
    private JTable tblRedesSociales;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1; //formulario para capturar fornites
    private JPanel panel2; //Tabla para mostrar los fortnites
    private JPanel panel3; //Mostrar imagen seleccionada del fortnite
    private JPanel panel4; //Eliminacion y actualizacion de campos
    private JLabel imagenRedesSociales;
    private JLabel lblDelete;
    private JButton btnDelete;
    private JTextArea txaActualizar;
    private JButton btnActualizar;
    private JTextField txtActualizar;
    public VentanaRedesSociales(String title) throws HeadlessException {
        super(title);
        this.setSize(800,800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(183, 153, 255));
        lblId = new JLabel("Id:");
        lblNombre = new JLabel("Nombre:");
        lblanioDeInicio = new JLabel("AñoDeInicio:");
        lblColorAplicacion = new JLabel("ColorAplicacion:");
        lblUsuarios = new JLabel("Usuarios:");
        lblUrl = new JLabel("URL:");
        txtId = new JTextField(2);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtNombre = new JTextField(10);
        txtanioDeInicio = new JTextField(10);
        txtColorAplicacion = new JTextField(6);
        txtUsuarios = new JTextField(7);
        txtUrl = new JTextField(23);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblanioDeInicio);
        panel1.add(txtanioDeInicio);
        panel1.add(lblColorAplicacion);
        panel1.add(txtColorAplicacion);
        panel1.add(lblUsuarios);
        panel1.add(txtUsuarios);
        panel1.add(lblUrl);
        panel1.add(txtUrl);
        panel1.add(btnAgregar);



        //panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(172, 188, 255));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblRedesSociales = new JTable();
        scrollPane = new JScrollPane(tblRedesSociales);
        panel2.add(scrollPane);

        //panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(174, 226, 255));
        imagenRedesSociales = new JLabel("...");
        panel3.add(imagenRedesSociales);


        //panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(230, 255, 253));
        lblDelete = new JLabel("Seleccione la fila que desee borrar y oprima el boton");
        btnDelete = new JButton("Delete");
        txaActualizar = new JTextArea("Actualizar:"+ "\n1.Escriba el nuevo valor." +
                "\n 2.Seleccione la casilla que desea sustituir" + " \n 3.Oprima el boton actualizar");
        txaActualizar.setBackground(null);
        txtActualizar = new JTextField(14);
        btnActualizar = new JButton("Actualizar");
        panel4.add(lblDelete);
        panel4.add(btnDelete);
        panel4.add(txaActualizar);
        panel4.add(txtActualizar);
        panel4.add(btnActualizar);


        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblanioDeInicio() {
        return lblanioDeInicio;
    }

    public void setLblanioDeInicio(JLabel lblanioDeInicio) {
        this.lblanioDeInicio = lblanioDeInicio;
    }

    public JLabel getLblColorAplicacion() {
        return lblColorAplicacion;
    }

    public void setLblColorAplicacion(JLabel lblColorAplicacion) {
        this.lblColorAplicacion = lblColorAplicacion;
    }

    public JLabel getLblUsuarios() {
        return lblUsuarios;
    }

    public void setLblUsuarios(JLabel lblUsuarios) {
        this.lblUsuarios = lblUsuarios;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtanioDeInicio() {
        return txtanioDeInicio;
    }

    public void setTxtanioDeInicio(JTextField txtanioDeInicio) {
        this.txtanioDeInicio = txtanioDeInicio;
    }

    public JTextField getTxtColorAplicacion() {
        return txtColorAplicacion;
    }

    public void setTxtColorAplicacion(JTextField txtColorAplicacion) {
        this.txtColorAplicacion = txtColorAplicacion;
    }

    public JTextField getTxtUsuarios() {
        return txtUsuarios;
    }

    public void setTxtUsuarios(JTextField txtUsuarios) {
        this.txtUsuarios = txtUsuarios;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JTable getTblRedesSociales() {
        return tblRedesSociales;
    }

    public void setTblRedesSociales(JTable tblRedesSociales) {
        this.tblRedesSociales = tblRedesSociales;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getImagenRedesSociales() {
        return imagenRedesSociales;
    }

    public void setImagenRedesSociales(JLabel imagenRedesSociales) {
        this.imagenRedesSociales = imagenRedesSociales;
    }

    public JLabel getLblDelete() {
        return lblDelete;
    }

    public void setLblDelete(JLabel lblDelete) {
        this.lblDelete = lblDelete;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JTextArea getTxaActualizar() {
        return txaActualizar;
    }

    public void setTxaActualizar(JTextArea txaActualizar) {
        this.txaActualizar = txaActualizar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JTextField getTxtActualizar() {
        return txtActualizar;
    }

    public void setTxtActualizar(JTextField txtActualizar) {
        this.txtActualizar = txtActualizar;
    }

    public void limpiar(){
        txtNombre.setText("");
        txtanioDeInicio.setText("");
        txtColorAplicacion.setText("");
        txtUsuarios.setText("");
        txtUrl.setText("");
        txtActualizar.setText("");

    }
}