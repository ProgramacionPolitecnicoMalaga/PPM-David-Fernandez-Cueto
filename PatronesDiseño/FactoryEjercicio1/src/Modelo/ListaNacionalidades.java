package Modelo;

import java.util.ArrayList;

public class ListaNacionalidades {
    ArrayList<Nacionalidad> nacionalidades;

    public ListaNacionalidades () {
        nacionalidades = new ArrayList<>();
    }

    public void addNacionalidad (Nacionalidad nacionalidad) {
        nacionalidades.add(nacionalidad);
    }

    public ArrayList<Nacionalidad> getNacionalidades() {
        return nacionalidades;
    }
}
