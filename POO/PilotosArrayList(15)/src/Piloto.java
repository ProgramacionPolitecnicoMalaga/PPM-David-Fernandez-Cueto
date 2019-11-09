import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Piloto {

    String nombre;
    String escudería;
    int posicionActual;

    public int getPosicionInicial() {
        return posicionInicial;
    }

    int posicionInicial;
    boolean descalificado;


    public int getPosicionActual() {
        return posicionActual ;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }


    public Piloto(int posicionActual, String nombre, String escudería) {
        this.nombre = nombre;
        this.escudería = escudería;
        this.posicionActual = posicionActual;
        descalificado = false;
        this.posicionInicial = posicionActual;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "posicion =" + posicionActual + '\'' +
                "nombre='" + nombre + '\'' +
                ", escudería='" + escudería;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscudería() {
        return escudería;
    }

    public void setEscudería(String escudería) {
        this.escudería = escudería;
    }

    public boolean isDescalificado() {
        return descalificado;
    }

    public void setDescalificado(boolean descalificado) {
        this.descalificado = descalificado;
    }




    public static Comparator<Piloto> COMPARE_BY_NAME = new Comparator<Piloto>() {
        @Override
        public int compare(Piloto piloto1, Piloto piloto2) {
         return piloto1.getNombre().compareToIgnoreCase(piloto2.getNombre());
        }
    };

    public static Comparator<Piloto> COMPARE_BY_POSITION = new Comparator<Piloto>() {
        @Override
        public int compare(Piloto piloto1, Piloto piloto2) {
            return piloto1.getPosicionActual() > piloto2.getPosicionActual() ? 1 :
                    piloto1.getPosicionActual() < piloto2.getPosicionActual() ? -1 :
                    0;
        }
    };

    public static Comparator<Piloto> COMPARE_BY_INITIALPOSITION = new Comparator<Piloto>() {
        @Override
        public int compare(Piloto piloto1, Piloto piloto2) {
            return piloto1.getPosicionInicial() > piloto2.getPosicionInicial() ? 1 :
                    piloto1.getPosicionInicial() < piloto2.getPosicionInicial() ? -1 :
                            0;
        }
    };
}
