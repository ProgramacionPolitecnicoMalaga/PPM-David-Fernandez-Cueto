package com.politecnicomalaga.vista;

import com.politecnicomalaga.DAO.DAOBaseDatos;

import javax.swing.*;
import java.awt.event.*;

public class Diálogo extends JDialog {
    private JPanel contentPane;
    private JButton butOk;
    private JButton butCancel;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private FormularioEmpleados ventanaPadre;
    private DAOBaseDatos daoBaseDatos;


    public Diálogo(FormularioEmpleados ventanaPadre) throws ClassNotFoundException {
        daoBaseDatos = new DAOBaseDatos();
        this.ventanaPadre = ventanaPadre;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(butOk);

        butOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        butCancel.addActionListener(new ActionListener() {
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

    private void onOK() {
        // add your code here
        daoBaseDatos.addEmpleado(txtNombre.getText(), Integer.parseInt(txtEdad.getText()));
        ventanaPadre.setTextEmpleados(txtNombre.getText(), txtEdad.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
