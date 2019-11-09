import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class RankingPilotos {
    ArrayList<Piloto> ranking = new ArrayList<>();
    String[] datospiloto = new String[50];

    public RankingPilotos() {
    }

    public void cargarPilotos () throws FileNotFoundException {
        String fileName = "pilotos.csv";
        File file = new File(fileName);

        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                datospiloto = data.split(";");
                Piloto piloto = new Piloto(Integer.parseInt(datospiloto[0]), datospiloto[1], datospiloto[2]);
                ranking.add(piloto);
                //System.out.println(datospiloto[0]);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Piloto recorrerRanking (String nombre) {
        Iterator<Piloto> iterador = ranking.iterator();
        Piloto pilotoBuscado = null;
        while (iterador.hasNext()) {
            pilotoBuscado = iterador.next();
            if (pilotoBuscado.getNombre().equalsIgnoreCase(nombre)) {
                return pilotoBuscado;
            }
        }
    return pilotoBuscado; }



    public int getPosicion(String nombre) throws NullPointerException {
        int posicion;
        Piloto pilotoBuscado = recorrerRanking(nombre);
        if (pilotoBuscado.getNombre().equalsIgnoreCase(nombre)) {
            return recorrerRanking(nombre).getPosicionActual();
        }
        else throw new NullPointerException("No existe el piloto en el ranking");
    }



        public void addPiloto (Piloto piloto,int posicionDeSalida){

        }


        public void setNuevasPosiciones() {
        int posicion = 1;
        Iterator<Piloto> iterador = ranking.iterator();
        while (iterador.hasNext()) {
            iterador.next().setPosicionActual(posicion);
            posicion++;
        }
        }

    public void descalificarPiloto (String nombre) {
        Piloto pilotoAdescalificar = recorrerRanking(nombre);
        pilotoAdescalificar.setDescalificado(true);
        eliminarDescalificados();

    }

        public void eliminarDescalificados() {
        Iterator<Piloto> iterador = ranking.iterator();
        Piloto pilotoDescalificado = null;
        while (iterador.hasNext())
            //pilotoDescalificado = iterador.next();
            if (iterador.next().isDescalificado()) {
                iterador.remove();
            }
            ordenarPorPosicion();
            setNuevasPosiciones();
            ordenarAlfabeticamente();
           // else System.out.println("NO TA PASANDO NA");
        }

        public void retrasarPiloto (String nombre){
            Iterator<Piloto> iterador = ranking.iterator();
            Piloto pilotoQueAdelanta = null;
            while (iterador.hasNext()) {
                if (iterador.next().getNombre().equals(nombre)) {
                    Piloto pilotoAdelantado = iterador.next();

                    int indexAdelantado = ranking.indexOf(pilotoAdelantado);
                    pilotoQueAdelanta = ranking.get(indexAdelantado-1);
                    pilotoAdelantado.setPosicionActual(pilotoAdelantado.getPosicionActual()-1);
                    pilotoQueAdelanta.setPosicionActual(pilotoQueAdelanta.getPosicionActual()+1);
                    Collections.swap(ranking, indexAdelantado-1, indexAdelantado);
                }
            }

        }

        public void adelantarPiloto (String nombre) {
        Piloto pilotoQueAdelanta = recorrerRanking(nombre);
       /* int indexPilotoQueAdelanta = ranking.indexOf(pilotoQueAdelanta);
        Piloto pilotoAdelantado = ranking.get(indexPilotoQueAdelanta-1);
        pilotoQueAdelanta.setPosicionActual(pilotoQueAdelanta.getPosicionActual()-1);
        pilotoAdelantado.setPosicionActual(pilotoAdelantado.getPosicionActual()+1); */
        int posicionPilotoQueAdelanta = pilotoQueAdelanta.getPosicionActual();
            //System.out.println(posicionPilotoQueAdelanta);

        for (int i = 0; i < ranking.size(); i++) {
            if ((posicionPilotoQueAdelanta-1 == (ranking.get(i).getPosicionActual()))) {
                ranking.get(i).setPosicionActual(posicionPilotoQueAdelanta);
            }
        }
            pilotoQueAdelanta.setPosicionActual(posicionPilotoQueAdelanta-1);


        }




        public void imprimirRanking (){
            Iterator<Piloto> iterador = ranking.iterator() ;
            System.out.println("=========================================================");
            while (iterador.hasNext()) {
                //System.out.print(posicionRanking);
                System.out.println(iterador.next());
               // System.out.println();
        }
            System.out.println("=========================================================");
            System.out.println();
        }

        public void ordenarAlfabeticamente() {
        Collections.sort(ranking, Piloto.COMPARE_BY_NAME);
        }

        public void ordenarPorPosicion() {
        Collections.sort(ranking, Piloto.COMPARE_BY_POSITION);
        }

        public void ordenarPorPosicionInicial() {
        Collections.sort(ranking, Piloto.COMPARE_BY_INITIALPOSITION);
    }

        public static void main (String[]args) throws FileNotFoundException {
            RankingPilotos nuevoRanking = new RankingPilotos();
            nuevoRanking.cargarPilotos();


            nuevoRanking.imprimirRanking();
            nuevoRanking.ordenarAlfabeticamente();
            nuevoRanking.imprimirRanking();
            nuevoRanking.adelantarPiloto("Hamilton L.");
            nuevoRanking.adelantarPiloto("Hamilton L.");
            nuevoRanking.imprimirRanking();
            nuevoRanking.descalificarPiloto("Albon A.");
            nuevoRanking.descalificarPiloto("Grosjean R.");
            nuevoRanking.imprimirRanking();
            nuevoRanking.ordenarPorPosicion();
            nuevoRanking.ordenarPorPosicionInicial();
            nuevoRanking.imprimirRanking();
    }


        }
