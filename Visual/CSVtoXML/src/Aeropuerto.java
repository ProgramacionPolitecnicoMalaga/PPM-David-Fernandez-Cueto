public class Aeropuerto {

    String nombre;
    String ciudad;
    String pais;
    String iata;
    double lat;
    double lon;

    public Aeropuerto(String nombre, String ciudad, String pais, String iata, double lat, double lon) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.iata = iata;
        this.lat = lat;
        this.lon = lon;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public String getIata() {
        return iata;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
