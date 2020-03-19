package com.politecnico.DAO;

import com.politecnico.modelo.Empleado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAO {

    private DBconn conn;

    public EmpleadoDAO() throws SQLException {
        conn = new DBconn();
    }

    public ArrayList<Empleado> buscarPorPatron(String patron) throws SQLException {
        ResultSet rs = conn.read("SELECT id, nombre, edad FROM Empleado WHERE nombre LIKE '%"+patron+"%'");
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        while (rs.next()) {
            listaEmpleados.add(new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad")));
        }
    return listaEmpleados; }

    public ArrayList<Empleado> ObtenerEmpleados() throws SQLException {
        ResultSet rs = conn.read(("SELECT * FROM Empleado"));
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        while (rs.next()) {
            listaEmpleados.add(new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad")));
        }
    return  listaEmpleados; }

    public void EliminarEmpleadoPorID(String ID) throws SQLException {
        conn.create("DELETE FROM Empleado WHERE id LIKE '"+ID+"'");
    }

    public int crear (String nombre, int edad) throws SQLException {
       return conn.create("INSERT INTO Empleado (nombre, edad) values ('"+nombre+"', '"+edad+"')");
    }

    public int modificarEmpleado (String nombre, int edad, String id) throws SQLException {
        return conn.create("UPDATE Empleado SET nombre = '"+nombre+"', edad = '"+edad+"' WHERE id = '"+id+"'");
    }
}
