import abstract_factory.SelectorJuego;
import producto.*;

public class AppJuego {
    public static SelectorJuego selectorJuego;
    public static Jugador jugador = null;
    public static Villano villano = null;
    public static Obstáculo obstáculo = null;
    public final static int SELVA = 1;
    public final static int DESIERTO = 2;
    public final static int ESPACIO = 3;

    public static void main(String[] args) {
        inicializar();

        System.out.println("Jugador: " + jugador.getNombreJugador() + "\n" +
                "Villano: " + villano.getNombreVillano() + " \n" +
                "Obstáculo: " + obstáculo.getNombreObstáculo());

    }



    public static void inicializar() {
        selectorJuego = new SelectorJuego();
        int escenario_elegido = selectorJuego.SelectorJuego();


        switch (escenario_elegido) {
            case SELVA:
                jugador = new Indiana();
                villano = new Molaram();
                obstáculo = new CarceleroTurco();
                break;
            case DESIERTO:
                jugador = new Patton();
                villano = new Rommel();
                obstáculo = new Tanques();
                break;
            case ESPACIO:
                jugador = new USSEnterprise();
                villano = new Khan();
                obstáculo = new NavesKlingon();

        }
    }
}
