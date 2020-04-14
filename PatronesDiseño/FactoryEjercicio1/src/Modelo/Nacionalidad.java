package Modelo;

public class Nacionalidad {

    String nacionalidad;
    int anio;
    int empadronados;

    public Nacionalidad (String nacionalidad, int anio, int empadronados) {
        this.nacionalidad = nacionalidad;
        this.anio = anio;
        this.empadronados = empadronados;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getAnio() {
        return anio;
    }

    public int getEmpadronados() {
        return empadronados;
    }
}
