package com.politecnicomalaga.DAO;

import com.politecnicomalaga.Modelo.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DAOitemsBD {

    private BDConn conn;

    public DAOitemsBD() throws SQLException, ClassNotFoundException {
        conn = new BDConn();
    }

    public void addItemBD(String titulo, LocalDate fecha, String texto, String tema) throws SQLException {
        conn.create("INSERT INTO items (titulo, fecha, texto, tema) values ('"+titulo+"', '"+fecha+"','"+texto+"','"+tema+"')");
    }

    public void eliminarItemBD(String titulo) throws SQLException {
        conn.create("DELETE FROM items WHERE titulo LIKE '"+titulo+"'");
    }

    public ArrayList<Item> cargarItems () throws SQLException {
        ArrayList<Item> items = new ArrayList<>();
        ResultSet rs = conn.read("SELECT * FROM items");
        while (rs.next()) {
            items.add(new Item(rs.getString("titulo"), rs.getObject(2, LocalDate.class), rs.getString("texto"), rs.getString("tema")));
        }
    return items; }
}
