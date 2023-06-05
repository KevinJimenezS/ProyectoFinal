package org.example.ProyectoFinal.Controlador;

import org.example.ProyectoFinal.Modelo.ModeloAnime;
import org.example.ProyectoFinal.Modelo.OnePiece;
import org.example.ProyectoFinal.Vista.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class Controlador extends MouseAdapter {

    private Ventana view;
    private ModeloAnime modelo;

    public Controlador(Ventana view) {
        this.view = view;
        modelo = new ModeloAnime();
        this.view.getTblAnime().setModel(modelo);
        this.view.getTblAnime().updateUI();

        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblAnime().addMouseListener(this);
        this.view.getBtnDelete().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {

            modelo.cargarDatos();
            this.view.getTblAnime().setModel(modelo);
            this.view.getTblAnime().updateUI();
        }
        if (e.getSource() == this.view.getBtnAgregar()) {
            OnePiece OP = new OnePiece();
            OP.setId(0);
            OP.setPersonaje(this.view.getTxtPersonaje().getText());
            OP.setSeriepl(this.view.getTxtSeriePelicula().getText());
            OP.setAnio(Integer.parseInt(this.view.getTxtAnio().getText()));
            OP.setEstatura(Double.parseDouble(this.view.getTxtEstatura().getText()));
            OP.setUrl(this.view.getTxtUrl().getText());
            if (modelo.agregarPersonaje(OP)) {
                JOptionPane.showMessageDialog(view, "SE AGREGO CORRECTAMENTE", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblAnime().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "NO SE PUDO AGREGAR, REVISAR CONEXION", "ERROR INTO", JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpiar();
        }
        if (e.getSource() == view.getTblAnime()) {
            System.out.println("Evento activo");
            int index = this.view.getTblAnime().getSelectedRow();
            OnePiece tmp = modelo.getOnePiceIndex(index);
            try {
                this.view.getImagen().setIcon(tmp.getImagen());
                this.view.getImagen().setText("");
            } catch (MalformedURLException mfue) {
                System.out.println("Imagen Inexistente");
            }
        }

        if (e.getSource() == view.getBtnDelete()) {
            int index = this.view.getTblAnime().getSelectedRow();
            int id = modelo.getOnePiceIndex(index).getId();
            int respuesta = JOptionPane.showConfirmDialog(view, "¿Seguro que quieres eliminar este dato?", "ATENCION", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                if (modelo.borrar(id)) {
                    JOptionPane.showMessageDialog(view, "SE ELIMINO EXITOSAMENTE");

                    modelo.cargarDatos();
                    this.view.getTblAnime().setModel(modelo);
                    this.view.getTblAnime().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "ESTE DATO NO SE MODIFICA");
                }
            }
        }

        if (e.getSource() == view.getBtnActualizar()) {

            try {
                Object o = this.view.getTxtActualizar().getText();
                int index = this.view.getTblAnime().getSelectedRow();
                int id = modelo.getOnePiceIndex(index).getId();
                int columna = this.view.getTblAnime().getSelectedColumn();

                if (modelo.actualizarElemento(o, id, columna)) {
                    JOptionPane.showMessageDialog(view, "SE ACTUAIZO EXITOSAMENTE");
                    this.view.limpiar();
                    modelo.cargarDatos();
                    this.view.getTblAnime().setModel(modelo);
                    this.view.getTblAnime().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "ESTE DATO NO SE MODIFICA");
                }
            } catch (ClassCastException cce) {
                Object o = Double.parseDouble(this.view.getTxtActualizar().getText());
                int index = this.view.getTblAnime().getSelectedRow();
                int id = modelo.getOnePiceIndex(index).getId();
                int columna = this.view.getTblAnime().getSelectedColumn();

                if (modelo.actualizarElemento(o, id, columna)) {
                    JOptionPane.showMessageDialog(view, "SE ACTUALIZO EXITOSAMENTE");
                    modelo.cargarDatos();
                    this.view.getTblAnime().setModel(modelo);
                    this.view.getTblAnime().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "ESTE DATO NO SE MODIFICA");
                }
            }
        }
    }
}

