package org.example;

import org.example.controlador.ControladorRedesSociales;
import org.example.interfaz.VentanaRedesSociales;
public class Main {
    public static void main(String[] args) {
        VentanaRedesSociales view = new VentanaRedesSociales("Redes Sociales");
        ControladorRedesSociales controller = new ControladorRedesSociales(view);
    }

}