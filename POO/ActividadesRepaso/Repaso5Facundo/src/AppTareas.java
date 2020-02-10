import java.security.PublicKey;
import java.util.Date;

public class AppTareas {


    public static void main(String[] args) {


    ListaCategorias listaCategorias = new ListaCategorias();

    //CREAR NUEVAS CATEGORIAS
    Categoria categoriaOcio = new Categoria("Ocio");
    Categoria categoriaClase = new Categoria("Clase");
    Categoria categoriaTrabajo = new Categoria("Trabajo");

    listaCategorias.addCategoria(categoriaOcio);
    listaCategorias.addCategoria(categoriaClase);
    listaCategorias.addCategoria(categoriaTrabajo);

    //MOSTRAR TODAS LAS CATEGORÍAS EXISTENTES
        listaCategorias.mostrarLista();


        //CREAR NUEVAS TAREAS

        Tarea tareas = new Tarea();

        Tarea pintarCoche = new Tarea("Preparar y pintar el coche", new Date(2020, 2, 20));
        categoriaTrabajo.addTareaEnCategoria(pintarCoche);

        Tarea realizarProgramacion = new Tarea("Repasar lo aprendido en clase", new Date(2020, 3, 12));
        categoriaClase.addTareaEnCategoria(realizarProgramacion);

        Tarea escucharNuevoDisco = new Tarea("Escuchar  nuevo disco de TOP", new Date(2020, 0, 22));

        //MOSTRAR LAS TAREAS PENDIENTES
        tareas.mostrarTareasPendientes();

        //COMPLETAR UNA TAREA
        realizarProgramacion.completarTarea();

        //MONSTRAR TAREAS COMPLETADAS
        tareas.mostrarTareasCompletadas();

        //MOSTRAR TAREAS EN LA CATEGORIA DE CLASE
        categoriaClase.mostrarTareasEnCategoria();

        // MOSTRAR TAREAS EN UNA FECHA

        tareas.mostrarTareasPorFecha(new Date(2020, 2, 20));

        Date fechaprueba = new Date();


        //MOSTRAR TAREAS EN TIEMPO
        tareas.mostrarTareasEnTiempo();

        //MOSTRAR TAREAS RETRASADAS
        tareas.mostrarTareasRetrasadas();

    }

}
