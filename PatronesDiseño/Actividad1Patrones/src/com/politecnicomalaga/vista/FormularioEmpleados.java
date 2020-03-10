package com.politecnicomalaga.vista;

import com.politecnicomalaga.DAO.DAOBaseDatos;
import com.politecnicomalaga.DAO.DBConn;
import com.politecnicomalaga.modelo.Empleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class FormularioEmpleados {
    private JPanel PanelMain;
    private JTextField txtNombre;
    private JTextArea txtEmpleados;
    private JButton butBuscar;
    private JButton butAdd;
    private JButton butEliminar;
    private JButton butModificar;
    private JLabel lblPrueba;
    private FormularioEmpleados estaVentana;

    public FormularioEmpleados() throws ClassNotFoundException {
        DAOBaseDatos daoBaseDatos = new DAOBaseDatos();
        estaVentana = this;

        butBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                ArrayList<Empleado> empleados;
                try {
                    empleados = daoBaseDatos.buscarEmpleado(nombre);
                    for (Empleado empleado : empleados) {
                        txtEmpleados.setText(txtEmpleados.getText() + " Nombre: " + empleado.getNombre() +
                                " Edad: " + empleado.getEdad()+"\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        butAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Diálogo diálogo = null;
                try {
                    diálogo = new Diálogo(estaVentana);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                diálogo.setLocationRelativeTo(SwingUtilities.getRoot((Component) actionEvent.getSource()));
                diálogo.pack();
                diálogo.setVisible(true);

            }
        });
    }

    public void setTextEmpleados(String nombre, String edad) {
        txtEmpleados.setText(nombre + edad);
    }

    public void setLblPrueba(String valor) {
        lblPrueba.setText(valor);
    }

    public JPanel getPanelMain() {
        return PanelMain;
    }
}
