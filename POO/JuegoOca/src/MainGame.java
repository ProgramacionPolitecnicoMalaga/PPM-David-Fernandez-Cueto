public class MainGame {

    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Dado dado = new Dado();

        Jugador player1 = new Jugador("Rojo", "Roberto");
        Jugador player2 = new Jugador("Verde", "Lucía");

        player1.adelantarJugador(dado.lanzarDado());
        player1.adelantarJugador(dado.lanzarDado());
        System.out.println(player1.historialMovimientos.get(player1.historialMovimientos.size()-1));

        player1.reDo();
        player1.unDo();
        player1.retrocederACasilla(2);

        System.out.println(player1);

    }
}
