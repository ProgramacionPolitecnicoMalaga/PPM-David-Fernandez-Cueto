import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Iterator;

public class Categoria {

  String tipoCategoria;
  ArrayList<Tarea> listaTareas;

  public Categoria (String tipoCategoria) {
      this.tipoCategoria = tipoCategoria;
      listaTareas = new ArrayList<>();
  }

  public void addTareaEnCategoria (Tarea tarea) {
      listaTareas.add(tarea);
  }

  public void mostrarTareasEnCategoria () {
      System.out.println("TAREAS EN LA CATEGORIA " + tipoCategoria);
      Iterator<Tarea> iterator = listaTareas.iterator();
      while (iterator.hasNext()) {
          System.out.println(iterator.next());
      }
      System.out.println("==========================");
  }

    @Override
    public String toString() {
        return "Categoria{" +
                "tipoCategoria='" + tipoCategoria + '\'' +
                '}';
    }
}
