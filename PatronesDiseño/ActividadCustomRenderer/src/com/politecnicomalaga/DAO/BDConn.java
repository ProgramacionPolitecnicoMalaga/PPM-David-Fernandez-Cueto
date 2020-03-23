package com.politecnicomalaga.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDConn {

        private Connection conn;
        private final String url = "jdbc:mariadb://localhost:3306/reader";
        private final String user = "david";
        private final String pass = "Perro20";
        private final String driver = "org.mariadb.jdbc.Driver";


        public BDConn () throws SQLException, ClassNotFoundException {
            try {
                Class.forName(driver);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
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

