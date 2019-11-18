public class Dado {

    int resultado;

    public Dado() {
    }

    public int lanzarDado() {
        resultado = (int) (Math.random()*6+1);
    return  resultado;
    }


}
