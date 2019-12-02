import javax.xml.transform.stream.StreamResult;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Empleado {

    private static final int TECNICO = 1;
    private static final int ADMINISTRADOR = 2;
    private static final int PROGRAMADOR = 3;
    private static final int JEFE_PROYECTO = 4;
    private static final int JEFE_OPERACIONES = 5;


    private String nombreCompleto;
    private String DNI;
    private int categoría;
    private double productividad;
    private double horasPorProyectos;
    private Sueldo sueldo;
    private LinkedList<Actividad> actividadesInscritas = new LinkedList<>();


    public Empleado () {
    }

    public Empleado(String nombreCompleto, String DNI, int categoría, Sueldo sueldo) {
        this.nombreCompleto = nombreCompleto;
        this.DNI = DNI;
        this.categoría = categoría;
        productividad = 0;
        horasPorProyectos = 0;
        this.sueldo = new Sueldo(categoría);
    }

    public void setProductividad(double productividad) {
        this.productividad = productividad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDNI() {
        return DNI;
    }

    public String getCategoría() {
        String descripciónCategoría;

        switch (categoría){
            case 1: descripciónCategoría=  "Ténico";
            break;
            case 2: descripciónCategoría=  "Administrador";
            break;
            case 3: descripciónCategoría=  "Programador";
            break;
            case 4: descripciónCategoría=  "Jefe de Proyecto";
            break;
            case 5: descripciónCategoría=   "Jefe de Operaciones";
            break;
            default: descripciónCategoría=  "No definida";
        }
        return descripciónCategoría;
    }

    public double getProductividad() {
        return productividad;
    }

    public double getSueldoBase() {
        return sueldo.getSueldoBase();
    }

    public double getSueldoTotal() {
       return sueldo.getSueldoTotal(this);
    }


    public void setHorasPorProyectos(double horasPorProyectos) {
        this.horasPorProyectos += horasPorProyectos;
    }

    public double getHorasPorProyectos() {
        return horasPorProyectos;
    }


    public void inscribirseEnActividad(Actividad actividad) {
        actividadesInscritas.add(actividad);
        setProductividad(actividad.proyecto.getFprod());
        setHorasPorProyectos(actividad.proyecto.duracionHoras);
    }

    public String getActividadesInscritas () {
        ListIterator<Actividad> iterador = actividadesInscritas.listIterator();
        System.out.println("Lista de actividades a realizar por " + this.getNombreCompleto());
        String actividades = "";
        while (iterador.hasNext()) {
            actividades += iterador.next() + "\n";
        }
   return actividades; }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", DNI='" + DNI + '\'' +
                ", categoría=" + categoría +
                ", productividad=" + productividad +
                ", horasPorProyectos=" + horasPorProyectos +
                ", sueldo=" + sueldo +
                ", actividadesInscritas=" + actividadesInscritas +
                '}' + "\n";
    }
}

