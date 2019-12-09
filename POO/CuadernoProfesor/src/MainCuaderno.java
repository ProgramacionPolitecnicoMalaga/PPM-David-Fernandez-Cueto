import java.util.LinkedList;

public class MainCuaderno {

    public static void main(String[] args) {
        Asignatura Programacion = new Asignatura("01", "Programación");
        Asignatura EntornosDeDesarrollo = new Asignatura("02", "Entornos de Desarrollo");
        Asignatura LenguajeDeMarcas = new Asignatura("03", "Lenguaje de Marcas");
        Asignatura DesarrolloDeDroides = new Asignatura("11", "Desarrollo de Droides");

        Curso S11AW = new Curso("S11AW", "Desarrollo de Aplicaciones Web");
        Curso C3PO = new Curso("C3PO", "Montaje de Droides");

        ListadeCursos cursos = new ListadeCursos();
        cursos.addCurso(S11AW);
        cursos.addCurso(C3PO);

        C3PO.addAsignaturaAlCurso(DesarrolloDeDroides);

        S11AW.addAsignaturaAlCurso(Programacion);
        S11AW.addAsignaturaAlCurso(EntornosDeDesarrollo);
        S11AW.addAsignaturaAlCurso(LenguajeDeMarcas);

        Alumno David = new Alumno("David Fdez", "0001");
        Alumno Roberto = new Alumno("Roberto Miguel", "0002");

        Programacion.matricularAlumno(David);
        Programacion.matricularAlumno(Roberto);

        Programacion.setIndicadorAlumno(David, new Indicador(David.getNombreCompleto(), Programacion, "Examen trimestral", 7.5));
        Programacion.setIndicadorAlumno(David, new Indicador(David.getNombreCompleto(), Programacion, "Examen trimestral", 6.5));
        Programacion.setIndicadorAlumno(Roberto, new Indicador(Roberto.getNombreCompleto(), Programacion, "Examen trimestral", 7.5));
        Programacion.setIndicadorAlumno(Roberto, new Indicador(Roberto.getNombreCompleto(), Programacion, "Examen trimestral", 6.5));

        System.out.println(Programacion.getNotas());

        cursos.escribiXML();



    }
}
