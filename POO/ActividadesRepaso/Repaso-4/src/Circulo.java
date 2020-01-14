public class Circulo extends Figura {
    double radio;

    public Circulo (String color, double radio) {
        super(color);
        this.radio = radio;
        tipo = Circulo.class.getName();
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radio, 2);
    }
}
