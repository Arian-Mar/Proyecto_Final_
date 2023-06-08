package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class RedesSociales {
    private int id;
    private String nombre;
    private String anioDeInicio;
    private String colorAplicacion;
    private String usuarios;
    private String imagenurl;

    public RedesSociales() {
    }

    public RedesSociales(int id, String nombre, String arma, String baile, String ubicacion, String url) {
        this.id = id;
        this.nombre = nombre;
        this.anioDeInicio = arma;
        this.colorAplicacion = baile;
        this.usuarios = ubicacion;
        this.imagenurl = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnioDeInicio() {
        return anioDeInicio;
    }

    public void setAnioDeInicio(String anioDeInicio) {
        this.anioDeInicio = anioDeInicio;
    }

    public String getColorAplicacion() {
        return colorAplicacion;
    }

    public void setColorAplicacion(String colorAplicacion) {
        this.colorAplicacion = colorAplicacion;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public String getImagenUrl() {
        return imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }

    @Override
    public String toString() {
        return "RedesSociales{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", añoDeInicio='" + anioDeInicio + '\'' +
                ", ColorAplicacion=" + colorAplicacion +
                ", usuarios='" + usuarios + '\'' +
                ", imagenurl='" + imagenurl + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImage = new URL(this.imagenurl);
        return new ImageIcon(urlImage);
    }

    public void setImagenUrl(String text) {
    }
}
