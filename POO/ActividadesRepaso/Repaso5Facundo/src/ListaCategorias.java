import javafx.beans.binding.When;
import jdk.nashorn.api.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaCategorias {

    ArrayList<Categoria> listaCategorias = new ArrayList<>();

    /*public ListaCategorias() {
        listaCategorias = new ArrayList<>();
    }*/

    public void addCategoria(Categoria categoria) {
        listaCategorias.add(categoria);
    }


    public void mostrarLista () {
        Iterator<Categoria> iterator = listaCategorias.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public String toString() {
        return "ListaCategorias{" +
                "listaCategorias=" + listaCategorias +
                '}';
    }
}
