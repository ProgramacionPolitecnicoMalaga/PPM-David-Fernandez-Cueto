package com.politecnico.controlador;

import com.politecnico.DAO.EmpleadoDAO;
import com.politecnico.modelo.Empleado;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorEmpleado {

    public ArrayList<Empleado> getEmpleados() {
        ArrayList<Empleado> listaEmpleados = null;
        try {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            listaEmpleados = empleadoDAO.ObtenerEmpleados();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return  listaEmpleados;
    }

    public ArrayList<Empleado> getEmpleadosPorPatron(String patron) {
        ArrayList<Empleado> listaEmpleados = null;
        try {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            listaEmpleados = empleadoDAO.buscarPorPatron(patron);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  listaEmpleados;
    }

    public void Añadir (String nombre, int edad) throws SQLException {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        empleadoDAO.crear(nombre, edad);
    }

    public void Eliminar (String ID) throws SQLException {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        empleadoDAO.EliminarEmpleadoPorID(ID);
    }

    public void Modificar (String nombre, int edad, String ID) throws SQLException {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        empleadoDAO.modificarEmpleado(nombre,edad,ID);
    }

}
