public class AppMensajeria {

    public static void main(String[] args) {

        TablonEtiquetas tablonEtiquetas = new TablonEtiquetas();

        Persona invitado1 = new Invitado("Manuel");
        // No puede escribir mensajes

        PersonaEscritora manager1 = new Manager("Juan");
        PersonaEscritora participante1 = new Participante("Lucía");

        manager1.escribirMensaje("Se inaugura el tablón", TiposDeMensaje.ETIQUETA, null, tablonEtiquetas);
        manager1.escribirMensaje("Cortar el césped", TiposDeMensaje.TAREA, invitado1, null);

        System.out.println(tablonEtiquetas.getEtiquetasPublicadas());

        invitado1.imprimirTareasPendientes();
        invitado1.realizarTarea(0);
        invitado1.imprimirTareasPendientes();
        invitado1.imprimirTareasRealizadas();


    }
}
