public class Indicador {

    String tipo;
    double nota;
    Alumno alumno;

    public Indicador(String nombreAlumno, Asignatura asignatura,  String tipo, double nota) {
        this.tipo = tipo;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Indicador{" +
                "tipo='" + tipo + '\'' +
                ", nota=" + nota +
                ", alumno=" + alumno +
                '}' + '\n';
    }
}
