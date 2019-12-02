import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MainPruebas {

    public static void main(String[] args) throws IOException {
        LinkedList<Empleado> listaEmpleados = new LinkedList<>();
        Actividad actividad = new Actividad();
        XMLProyectos lectorXML = new XMLProyectos();

        Empleado empleado1 = new Empleado("Jorge Javier Vázquez", "2324T", 3, new Sueldo(3));
        Empleado empleado2 = new Empleado("Marcos González", "2908R", 2, new Sueldo(2));

        listaEmpleados.add(empleado1);
        listaEmpleados.add(empleado2);

        //Leemos los proyectos del archivo XML
        lectorXML.leerXML("proyectos.xml");




        //Cada vez que creamos una actividad, la asignamos a un proyecto.
        empleado1.inscribirseEnActividad(new Actividad(actividad.DESARROLLO, lectorXML.listaProyectos.get(0)));
        empleado1.inscribirseEnActividad(new Actividad(actividad.MANTENIMIENTO, lectorXML.listaProyectos.get(0)));


        System.out.println(empleado1.getSueldoBase());
        System.out.println(empleado1.getSueldoTotal());

        System.out.println(empleado1.getHorasPorProyectos());


        empleado1.getActividadesInscritas();
        System.out.println(empleado1.getProductividad());

        System.out.println(lectorXML.listaProyectos);



        GeneradorXMLEmpleado generadorXMLEmpleado = new GeneradorXMLEmpleado();
        generadorXMLEmpleado.GenerarXML(listaEmpleados, "2324T");

        lectorXML.generarXMLProyectoActividad("Alphasec");


        System.out.println(listaEmpleados);


    }
}
