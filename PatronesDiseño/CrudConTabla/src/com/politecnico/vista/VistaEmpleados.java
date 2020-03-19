package com.politecnico.vista;

import com.politecnico.FormModal;
import com.politecnico.controlador.ControladorEmpleado;
import com.politecnico.modelo.Empleado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class VistaEmpleados {
    private JTextField txtPatron;
    private JButton butBuscar;
    private JPanel vistaEmpleados;
    private JTable tb;
    private JButton butEliminar;
    private JLabel lblPrueba;
    private JButton butModificar;
    private JButton butAdd;
    private ControladorEmpleado controlador;
    private VistaEmpleados estaVentana;
    private DefaultTableModel model = (DefaultTableModel) tb.getModel();

    public VistaEmpleados (ControladorEmpleado controlador){
        estaVentana = this;
        this.controlador = controlador;
        actualizarTabla(controlador.getEmpleados());

        butBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String patron = txtPatron.getText();
                ArrayList<Empleado> listaModificada = controlador.getEmpleadosPorPatron(patron);
                actualizarTabla(listaModificada);
            }
        });

        butEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = tb.getSelectedRow();
                String id = model.getValueAt(row, 0).toString();


                int respuesta = JOptionPane.showConfirmDialog(SwingUtilities.getRoot((Component) actionEvent.getSource()), "¿Estás seguro de querer eliminar este empleado? ID: '"+id+"'");
                if (respuesta == JOptionPane.OK_OPTION) {
                    try {
                        controlador.Eliminar(id);
                        actualizarTabla(controlador.getEmpleados());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else if (respuesta == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component) actionEvent.getSource()), "El empleado no ha sido eliminado");                }
                //controlador.Eliminar();

            }
        });

        butModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = tb.getSelectedRow();
                String id = model.getValueAt(row, 0).toString();
                String nombre = model.getValueAt(row, 1).toString();
                int edad = Integer.parseInt(model.getValueAt(row, 2).toString());
                try {
                    controlador.Modificar(nombre, edad, id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        butAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Dialogo dialogo = null;
                try {
                    dialogo = new Dialogo(estaVentana);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                dialogo.setLocationRelativeTo(SwingUtilities.getRoot((Component) actionEvent.getSource()));
                dialogo.pack();
                dialogo.setVisible(true);
            }
        });

    }


    public void actualizarTabla (ArrayList<Empleado> listaEmpleados) {
        model.setRowCount(0);
        //listaEmpleados = controlador.getEmpleados();
        model = (DefaultTableModel) tb.getModel();
        for (Empleado empleado : listaEmpleados) {
            Object [] row = {empleado.getId(), empleado.getNombre(), empleado.getEdad()};
            model.addRow(row);
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        tb=new JTable();
        Object[]columnas={"Id","Nombre","Edad"};
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.setColumnIdentifiers(columnas);
        tb.setModel(modelo);
    }

    public JPanel getVistaEmpleados() {
        return vistaEmpleados;
    }
}
