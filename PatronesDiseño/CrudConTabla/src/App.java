import com.mysql.cj.xdevapi.DbDoc;
import com.politecnico.DAO.DBconn;
import com.politecnico.DAO.EmpleadoDAO;
import com.politecnico.controlador.ControladorEmpleado;
import com.politecnico.modelo.Empleado;
import com.politecnico.vista.VistaEmpleados;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws SQLException {

        ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
        JFrame frame = new JFrame("Empleados");
        frame.setContentPane(new VistaEmpleados(controladorEmpleado).getVistaEmpleados());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        DBconn dbConn = new DBconn();
    }
}
