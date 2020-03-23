package com.politecnicomalaga;

import com.politecnicomalaga.DAO.DAOitemsBD;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Dialogo extends JDialog {
    private JPanel contentPane;
    private JButton butOk;
    private JButton buttonCancel;
    private JTextField txtTitulo;
    private JTextField txtTexto;
    private JTextField txtTipo;
    private JTextField txtDia;
    private JTextField txtMes;
    private JTextField txtAnio;
    private JComboBox boxTipos;
    private DAOitemsBD daOitemsBD;
    private ArrayList<String> temas;

    public Dialogo(VentanaPrincipal ventanaPrincipal) throws ClassNotFoundException, SQLException {
        cargarTemasComboBox();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(butOk);
        daOitemsBD = new DAOitemsBD();

        butOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
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

    public void cargarTemasComboBox () {
        temas = new ArrayList<>();
        temas.add("IT");
        temas.add("Desarrollo");
        temas.add("Mantenimiento");
        temas.add("General");
        boxTipos.setModel(new DefaultComboBoxModel<String>(temas.toArray(new String[0])));
    }

    private void onOK() throws SQLException {
        String titulo = txtTitulo.getText();
        int anio = Integer.parseInt(txtAnio.getText());
        int mes = Integer.parseInt(txtMes.getText());
        int dia = Integer.parseInt(txtDia.getText());
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        String texto = txtTexto.getText();
        String tema = boxTipos.getSelectedItem().toString();

        daOitemsBD.addItemBD(titulo, fecha, texto, tema);



        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
