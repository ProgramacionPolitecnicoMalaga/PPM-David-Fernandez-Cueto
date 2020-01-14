public abstract class Figura {

    String tipo;
    String color;
    double area;

    public Figura(String color) {
        this.color = color;
    }

    public abstract double getArea();

    @Override
    public String toString() {
        return "Figura{" +
                "tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", area=" + getArea() +
                '}';
    }
}
