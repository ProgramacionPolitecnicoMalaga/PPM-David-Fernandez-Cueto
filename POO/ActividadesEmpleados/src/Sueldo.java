public class Sueldo {

    public final int SB_TECNICO = 900;
    public final int SB_ADMINISTRADOR = 1400;
    public final int SB_PROGRAMADOR = 1800;
    public final int SB_JEFE_PROYECTO = 2500;
    public final int SB_JEFE_OPERACIONES = 3500;

    private double sueldoTotal;
    private int sueldoBase;
    Empleado empleado = new Empleado();

    public Sueldo(int categoria) {
        switch (categoria) {
            case 1:
                sueldoBase = SB_TECNICO;
                break;
            case 2:
                sueldoBase = SB_ADMINISTRADOR;
                break;
            case 3:
                sueldoBase = SB_PROGRAMADOR;
                break;
            case 4:
                sueldoBase = SB_JEFE_PROYECTO;
                break;
            case 5:
                sueldoBase = SB_JEFE_OPERACIONES;
        }
    }

    public double getSueldoBase() {
        return sueldoBase;
    }


    public double getSueldoTotal (Empleado empleado) {
        if (empleado.getProductividad() > 0 && empleado.getHorasPorProyectos() > 0)
            return sueldoTotal = empleado.getSueldoBase() + empleado.getProductividad()*empleado.getHorasPorProyectos();
        else return sueldoBase;

    }

    }
