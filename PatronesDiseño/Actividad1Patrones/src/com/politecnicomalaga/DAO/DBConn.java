package com.politecnicomalaga.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    Connection dbConn = null;


    public DBConn () {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
              String url = "jdbc:mysql://vps791421.ovh.net:3306/Empleados";
              String user = "empleadosuser";
              String pass = "Perro20";
             dbConn = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
     }
}
