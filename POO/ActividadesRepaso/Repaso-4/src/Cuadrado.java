public class Cuadrado extends Figura {

    double lado;

    public Cuadrado (String color, double lado) {
        super(color);
        this.lado = lado;
        tipo = Cuadrado.class.getName();
    }

    @Override
    public double getArea() {
        return lado*lado;
    }
}
