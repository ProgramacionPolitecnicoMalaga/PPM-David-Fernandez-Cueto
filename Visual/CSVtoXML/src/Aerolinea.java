public class Aerolinea {

    String nombre;
    String IATA;
    String pais;
    String cod;
    int id;

    public Aerolinea( int id, String nombre, String IATA, String cod, String pais) {
        this.nombre = nombre;
        this.IATA = IATA;
        this.pais = pais;
        this.cod = cod;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIATA() {
        return IATA;
    }

    public String getPais() {
        return pais;
    }

    public String getCod() {
        return cod;
    }

    public int getId() {
        return id;
    }
}
