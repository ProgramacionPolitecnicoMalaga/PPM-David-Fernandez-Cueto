import java.util.ArrayList;
import java.util.LinkedList;

public class Jugador {

    String color;
    String nombreJugador;
    int casillaActual;
    int indiceMovimiento = 1;
    LinkedList<Integer> historialMovimientos = new LinkedList<>();
    LinkedList<String> historial = new LinkedList<>();



    public Jugador(String color, String nombreJugador) {
        this.color = color;
        this.nombreJugador = nombreJugador;
        casillaActual = 0;
    }

    public void adelantarJugador(int resultadoDado) {
        casillaActual = casillaActual + resultadoDado;
        historial.add(indiceMovimiento + ". " + "Avance a la posición " + casillaActual);
        indiceMovimiento++;
        historialMovimientos.add(resultadoDado);
    }

    public void unDo () {
        int ultimoMovimiento = historialMovimientos.getLast();
        casillaActual = casillaActual - ultimoMovimiento;
        historial.removeLast();
    }

    public void reDo () {
        int ultimoMovimiento = historialMovimientos.get(historialMovimientos.size() -1);
        adelantarJugador(ultimoMovimiento);


    }

    public void retrocederACasilla (int numero) {
        casillaActual = numero;
        historial.add(indiceMovimiento + ". " + "Retrocede a la casilla " + casillaActual);
    }

    public LinkedList<String> getHistorial() {
        return historial;
    }

    @Override
    public String toString() {
        return "El jugador " + nombreJugador + " ha realizado los siguientes movimientos: " + "\n" +
                historial +
                '}';
    }
}
