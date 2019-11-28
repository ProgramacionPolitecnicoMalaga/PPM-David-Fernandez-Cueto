public class MainPruebas {

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Jorge Javier Vázquez", "2324T", 3, new Sueldo(3));

        System.out.println(empleado1.getSueldoBase());
        empleado1.setProductividad(2.5);
        empleado1.setHorasPorProyectos(6);
        System.out.println(empleado1.getSueldoTotal());

        System.out.println(empleado1.getHorasPorProyectos());

        empleado1.inscribirseEnActividad(new Actividad(3));
        empleado1.inscribirseEnActividad(new Actividad(4));

        empleado1.getActividadesInscritas();
    }
}
