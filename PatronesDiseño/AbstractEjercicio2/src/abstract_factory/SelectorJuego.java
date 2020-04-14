package abstract_factory;

import java.util.Scanner;

public class SelectorJuego {



    private int escenario = 0;

    public int SelectorJuego () {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escenario a jugar, introduce número: \n" +
                "1. SELVA \n" +
                "2. DESIERTO \n" +
                "3. ESPACIO");
        escenario = teclado.nextInt();
        existeEscenario();
    return escenario; }

    public void existeEscenario() {
        if (escenario != 1 && escenario != 2 && escenario != 3) {
            System.out.println("No existe este escenario, por favor, vuelva a introducir la opción.");
            SelectorJuego();
        }
    }


}
