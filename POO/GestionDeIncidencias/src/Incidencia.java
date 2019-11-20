public class Incidencia {

    int idIncidencia;
    String descripcion;
    String zonaAfectada;


    public Incidencia(int idIncidencia, String descripcion, String zonaAfectada) {
        this.idIncidencia = idIncidencia;
        this.descripcion = descripcion;
        this.zonaAfectada = zonaAfectada;
    }

    @Override
    public int hashCode() {
        return idIncidencia;
    }

    @Override
    public boolean equals(Object incidencia) {
        return idIncidencia == ((Incidencia) incidencia).getIdIncidencia();
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    @Override
    public String toString() {
        return "Incidencia{" +
                "idIncidencia=" + idIncidencia +
                ", descripcion='" + descripcion + '\'' +
                ", zonaAfectada='" + zonaAfectada + '\'' +
                '}' + "\n";
    }
}
