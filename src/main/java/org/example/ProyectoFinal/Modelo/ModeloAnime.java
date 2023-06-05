package org.example.ProyectoFinal.Modelo;

import org.example.ProyectoFinal.Persistencia.Anime;


import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloAnime implements TableModel {
    public static final int COLUMNS = 6;
    private ArrayList<OnePiece> datos;
    private Anime anm;

    public ModeloAnime() {
        anm = new Anime();
        datos = new ArrayList<>();
    }

    public ModeloAnime(ArrayList<OnePiece> datos) {
        this.datos = datos;
        anm = new Anime();
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
    public String getColumnName(int rowIndex) {
        switch (rowIndex) {
            case 0:
                return "ID";
            case 1:
                return "PERSONAJE";
            case 2:
                return "SERIE/PELICULA";
            case 3:
                return "AÑO";
            case 4:
                return "ESTATURA CM";
            case 5:
                return "URL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return Double.class;
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
        OnePiece tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getPersonaje();
            case 2:
                return tmp.getSeriepl();
            case 3:
                return tmp.getAnio();
            case 4:
                return tmp.getEstatura();
            case 5:
                return tmp.getUrl();

        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:

                break;
            case 1:
                datos.get(rowIndex).setPersonaje((String) o);
                break;
            case 2:
                datos.get(rowIndex).setSeriepl((String) o);
                break;
            case 3:
                datos.get(rowIndex).setAnio((Integer) o);
                break;
            case 4:
                datos.get(rowIndex).setEstatura((Double) o);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) o);
                break;
            default:
                System.out.println("NO SE MODIFICA NADA");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos() {

        try {
            ArrayList<OnePiece> tirar = anm.obtenerTodo();
            System.out.println(tirar);
            datos = anm.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public boolean agregarPersonaje(OnePiece OP) {
        boolean resultado = false;
        try {
            if (anm.insertar(OP)) {
                datos.add(OP);
                resultado = true;

            } else {
                resultado = false;

            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public OnePiece getOnePiceIndex(int idx) {
        return datos.get(idx);
    }

    public boolean borrar(int id) {
        boolean resultado = false;
        try {
            if (anm.delete(id)) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println("No se pudo");
        }
        return resultado;
    }

    public boolean actualizarElemento(Object o, int id, int columna) {
        boolean resultado = false;
        try {
            if (anm.updateElemento(o, id, columna)) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println("No se pudo");
        }
        return resultado;
    }
}
