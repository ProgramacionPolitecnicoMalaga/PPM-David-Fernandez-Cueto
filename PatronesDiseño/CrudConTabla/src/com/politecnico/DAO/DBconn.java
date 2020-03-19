package com.politecnico.DAO;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconn {

    private Connection conn;
    private final String url = "jdbc:mysql://vps791421.ovh.net:3306/Empleados";
    private final String user = "empleadosuser";
    private final String pass = "Perro20";
    private final String driver = "com.mysql.cj.jdbc.Driver";


    public DBconn () throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
    }

    public Connection getConn() {
        return conn;
    }

    public ResultSet read (String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeQuery();
    }

    public int create (String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeUpdate();
    }

}
