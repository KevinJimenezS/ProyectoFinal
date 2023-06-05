package org.example.ProyectoFinal;

import org.example.ProyectoFinal.Controlador.Controlador;
import org.example.ProyectoFinal.Vista.Ventana;

public class MainA {
    public static void main(String[] args) {

        Ventana view = new Ventana("MVC Y JDBC");
        Controlador controller = new Controlador(view);


    }
}