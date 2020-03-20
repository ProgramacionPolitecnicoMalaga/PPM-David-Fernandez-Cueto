import javafx.scene.control.Tab;

public class PersonaEscritora extends Persona{


    public PersonaEscritora(String nombre) {
        super(nombre);
    }


    public void escribirMensaje (String mensaje, int tipoMensaje, Persona destinatario, TablonEtiquetas tablon) {
        if (tipoMensaje == TiposDeMensaje.NOTIFICACION) {
            destinatario.notificaciones.add(mensaje);
        }
        else if (tipoMensaje == TiposDeMensaje.TAREA) {
            destinatario.tareasPendientes.add(mensaje);
        }
        else if (tipoMensaje == TiposDeMensaje.ETIQUETA) {
            tablon.addEtiquetaAlTablon(mensaje);
        }
    }
}
