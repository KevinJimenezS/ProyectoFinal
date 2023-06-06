package org.example.ProyectoFinal;

import org.example.ProyectoFinal.Controlador.Controlador;
import org.example.ProyectoFinal.Vista.Ventana;

public class MainA {
    public static void main(String[] args) {

        Ventana view = new Ventana("ONE PIECE");
        Controlador controller = new Controlador(view);


    }
}
