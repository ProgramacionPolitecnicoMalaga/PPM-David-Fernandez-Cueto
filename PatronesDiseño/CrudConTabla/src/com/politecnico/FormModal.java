package com.politecnico;

import com.politecnico.DAO.EmpleadoDAO;
import com.politecnico.controlador.ControladorEmpleado;
import com.politecnico.modelo.Empleado;
import com.politecnico.vista.VistaEmpleados;

import javax.swing.*;

public class FormModal {
    private JButton button1;
    private ControladorEmpleado controlador;
    private VistaEmpleados ventanaPadre;

    public FormModal (VistaEmpleados ventanaPadre) throws ClassNotFoundException {
        controlador = new ControladorEmpleado();
        this.ventanaPadre = ventanaPadre;



    }
}
