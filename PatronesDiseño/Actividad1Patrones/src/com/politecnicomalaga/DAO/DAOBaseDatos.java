package com.politecnicomalaga.DAO;

import com.politecnicomalaga.modelo.Empleado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOBaseDatos implements DAO {
    DBConn dbConn = new DBConn();
    String driver = "com.mysql.cj.jdbc.Driver";

    public DAOBaseDatos() throws ClassNotFoundException {
        dbConn = new DBConn();
    }




    @Override
    public void addEmpleado(String nombre, int edad) {
        try {
            dbConn.dbConn.prepareStatement("INSERT INTO Empleado(nombre, edad) VALUES ('"+nombre+"', '"+edad+"')").executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarEmpleado(String nombre, int edad) {
        
    }

    public ArrayList<Empleado> buscarEmpleado (String nombre) throws SQLException {
        ResultSet rs = cargarEmpleados();
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (rs.next()) {
            if (rs.getString("nombre").equalsIgnoreCase(nombre)) {
                empleados.add(new Empleado(rs.getString("Nombre"), rs.getInt("Edad")));
            }
        }
    return  empleados; }

    public ResultSet cargarEmpleados()  {
        ResultSet rs = null;
        try {
             rs = dbConn.dbConn.prepareStatement("SELECT * FROM Empleado").executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  rs; }
}
