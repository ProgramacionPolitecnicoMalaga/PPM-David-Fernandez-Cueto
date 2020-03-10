package com.politecnicomalaga.vista;

import com.politecnicomalaga.DAO.DAOBaseDatos;
import com.politecnicomalaga.DAO.DBConn;

import javax.swing.*;
import java.sql.SQLException;

public class MainPruebas {

    public static void main(String[] args) throws ClassNotFoundException {

         JFrame frame = new JFrame("Empleados");
            frame.setContentPane(new FormularioEmpleados().getPanelMain());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            DBConn dbConn = new DBConn();
        }

    }
