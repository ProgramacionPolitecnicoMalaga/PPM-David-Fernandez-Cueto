public class Main {

    public static void main(String[] args) {
        FigurasGeometricas figurasGeometricas = new FigurasGeometricas();

        figurasGeometricas.addFigura(new Circulo("rojo", 4));
        figurasGeometricas.addFigura(new Cuadrado("amarillo", 5));
        figurasGeometricas.addFigura(new Triangulo("verde", 6, 9));

        figurasGeometricas.mostrarFiguras();

    }
}
