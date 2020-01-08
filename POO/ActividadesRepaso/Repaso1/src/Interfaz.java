import java.util.Scanner;

public class Interfaz {

    Scanner teclado = new Scanner(System.in);

    String unidad;
    int opcion;
    int operacion;
    double cateto1;
    double cateto2;
    double hipotenusa;
    double area;

    public Interfaz () {
        menuUnidad();
        menuOperacion();
    }

    public void menuUnidad() {
        System.out.println("¿Qué unidad desea utilizar? \n" +
        "1. mm \n" +
        "2. cm \n" +
        "3. m \n" +
        "Introduzca una opción:");

        opcion = teclado.nextInt();
        establecerUnidad(opcion);
    }

    public void establecerUnidad (int opcion) {

        if (opcion < 1 || opcion > 3) {
            System.out.println("Introduzca una opción válida");
            menuUnidad();
        }
        else {
            switch (opcion) {
                case 1:
                    unidad = "mm";
                    break;
                case 2:
                    unidad = "cm";
                    break;
                case 3:
                    unidad = "m";
                    break;
            }
        }
    }

    public void menuOperacion () {
        System.out.println("¿Qué operación desea realizar? \n " +
                "1. Calcular la hipotenusa de un triángulo a aprtir de sus catetos. \n" +
        "2. Calcular un cateto de un triángulo a partir de el otro cateto y la hipotenusa \n" +
        "3. Calcular el área de un triángulo a partir un cateto y la hipotenusa \n" +
        "4. Caluclar el área de un triángulo a partir de dos catetos. \n" +
                "Elige una opción:)" );
        operacion = teclado.nextInt();
        realizarOperacion(operacion);
    }

    public void realizarOperacion (int operacion) {
        if (opcion < 1 || opcion > 4) {
            System.out.println("Introduzca una opción válida");
            menuOperacion();
        }

        switch (operacion) {
            case 1: operacion1();
            break;
            case 2: operacion2();
            break;
            case 3: operacion3();
            break;
            case 4: operacion4();
            break;
        }
    }

    public void operacion1 () {
        pedirCatetos();
        hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
        System.out.println("La hipotenusa es: " + hipotenusa + unidad);

    }

    public void operacion2 () {
        System.out.println("Introduce el valor del cateto");
        cateto1 = teclado.nextDouble();
        System.out.println("Introduce el valor de la hipotenusa");
        hipotenusa = teclado.nextDouble();
        cateto2 = Math.sqrt(Math.pow(hipotenusa, 2) - Math.pow(cateto1, 2));
        System.out.println("El valor del cateto es " + cateto2 + unidad);
    }

    public void operacion3 () {
        pedirCatetoEhipotenusa();
        cateto2 = Math.sqrt(Math.pow(hipotenusa, 2) - Math.pow(cateto1, 2));
        calcularArea();
        System.out.println("El área del triángulo es " + area + unidad + "^2");
    }

    public void operacion4 () {
        pedirCatetos();
        calcularArea();
        System.out.println("El área del triángulo es " + area + unidad + "^2");

    }

    public void pedirCatetos() {
        System.out.println("Introduce el valor del primer cateto");
        cateto1 = teclado.nextDouble();
        System.out.println("Introduce el valor del segundo cateto");
        cateto2 = teclado.nextDouble();
    }

    public void pedirCatetoEhipotenusa() {
        System.out.println("Introduce el valor del cateto");
        cateto1 = teclado.nextDouble();
        System.out.println("Introduce el valor de la hipotenusa");
        hipotenusa = teclado.nextDouble();
    }

    public void calcularArea() {
        area = (cateto1 * cateto2) / 2;
    }
}
