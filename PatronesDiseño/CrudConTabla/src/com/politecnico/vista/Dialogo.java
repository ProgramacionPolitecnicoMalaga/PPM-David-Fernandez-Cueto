package com.politecnico.vista;

import com.politecnico.DAO.EmpleadoDAO;
import com.politecnico.controlador.ControladorEmpleado;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Dialogo extends JDialog {
    private JPanel contentPane;
    private JButton butSI;
    private JButton butNO;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private ControladorEmpleado controlador;
    private VistaEmpleados ventanaPadre;

    public Dialogo(VistaEmpleados ventanaPadre) throws ClassNotFoundException {
        controlador = new ControladorEmpleado();
        this.ventanaPadre = ventanaPadre;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(butSI);

        butSI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        butNO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws SQLException {
        String nombre = txtNombre.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        controlador.Añadir(nombre, edad);

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
