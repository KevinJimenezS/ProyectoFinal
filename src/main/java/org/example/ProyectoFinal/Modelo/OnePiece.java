package org.example.ProyectoFinal.Modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class OnePiece {
    private int id;
    private String personaje;
    private String seriepl;
    private int anio;
    private double estatura;
    private String url;

    public OnePiece() {
    }

    public OnePiece(int id, String personaje, String seriepl, int anio, double estatura, String url) {
        this.id = id;
        this.personaje = personaje;
        this.seriepl = seriepl;
        this.anio = anio;
        this.estatura = estatura;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public String getSeriepl() {
        return seriepl;
    }

    public void setSeriepl(String seriepl) {
        this.seriepl = seriepl;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "OnePiece{" +
                "id=" + id +
                ", personaje='" + personaje + '\'' +
                ", seriepl='" + seriepl + '\'' +
                ", anio=" + anio +
                ", estatura=" + estatura +
                ", url='" + url + '\'' +
                '}' + '\n';
    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImage = new URL(this.url);
        return new ImageIcon(urlImage);
    }
}
