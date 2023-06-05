package org.example.ProyectoFinal.Persistencia;

import org.example.ProyectoFinal.Modelo.OnePiece;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Anime implements Interfaz {


    public Anime() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO onepiece(personaje, seriepl, anio, estatura, url) VALUES(?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = Conexion.getInstance("onePice.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((OnePiece) obj).getPersonaje());
        pstm.setString(2, ((OnePiece) obj).getSeriepl());
        pstm.setInt(3, ((OnePiece) obj).getAnio());
        pstm.setDouble(4, ((OnePiece) obj).getEstatura());
        pstm.setString(5, ((OnePiece) obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE onepiece SET personaje = ?, seriepl = ?,anio = ?,estatura = ?,url = ? WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = Conexion.getInstance("onePice.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((OnePiece) obj).getPersonaje());
        pstm.setString(2, ((OnePiece) obj).getSeriepl());
        pstm.setInt(3, ((OnePiece) obj).getAnio());
        pstm.setDouble(4, ((OnePiece) obj).getEstatura());
        pstm.setString(5, ((OnePiece) obj).getUrl());
        pstm.setInt(6, ((OnePiece) obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    public boolean updateElemento(Object obj, int id, int columna) throws SQLException {
        int rowCount = 0;
        String sqlDelete;
        PreparedStatement pstm = null;
        switch (columna) {
            case 0:
                System.out.println("No se puede actualizar un id");
                break;
            case 1:
                sqlDelete = "UPDATE onepiece SET personaje = ? WHERE id = ? ;";
                pstm = Conexion.getInstance("onePice.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String) obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 2:
                sqlDelete = "UPDATE onepiece SET seriepl = ? WHERE id = ? ;";
                pstm = Conexion.getInstance("onePice.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String) obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 3:
                sqlDelete = "UPDATE onepiece SET anio = ? WHERE id = ? ;";
                pstm = Conexion.getInstance("onePice.db").getConnection().prepareStatement(sqlDelete);
                pstm.setInt(1, (Integer) obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 4:
                sqlDelete = "UPDATE onepiece SET estatura = ? WHERE id = ? ;";
                pstm = Conexion.getInstance("onePice.db").getConnection().prepareStatement(sqlDelete);
                pstm.setDouble(1, (Double) obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 5:
                sqlDelete = "UPDATE onepiece SET url = ? WHERE id = ? ;";
                pstm = Conexion.getInstance("onePice.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String) obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
        }
        return rowCount > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sqlDelete = "DELETE FROM onepiece WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = Conexion.getInstance("onePice.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, id);
        rowCount = pstm.executeUpdate();


        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM onepiece";
        ArrayList<OnePiece> resultado = new ArrayList<>();

        Statement stm = Conexion.getInstance("onePice.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            resultado.add(new OnePiece(rst.getInt(1), rst.getString(2),
                    rst.getString(3), rst.getInt(4), rst.getDouble(5),
                    rst.getString(6)));
        }

        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM onepiece WHERE id = ? ;";
        OnePiece OP = null;

        PreparedStatement pstm = Conexion.getInstance("onePice.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            OP = new OnePiece(rst.getInt(1), rst.getString(2),
                    rst.getString(3), rst.getInt(4), rst.getDouble(5),
                    rst.getString(6));
            return OP;
        }
        return null;

    }
}
