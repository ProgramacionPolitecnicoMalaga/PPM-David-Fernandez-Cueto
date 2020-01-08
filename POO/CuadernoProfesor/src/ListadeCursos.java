import com.sun.source.tree.WhileLoopTree;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListadeCursos {

    ArrayList<Curso> cursos;

    public ListadeCursos() {
        cursos = new ArrayList<>();
    }

    public void addCurso (Curso curso) {
        cursos.add(curso);
    }

    public void escribiXML () {

        String xmlSerializado = "<cursos>";
        Iterator<Curso> itCursos = cursos.iterator();

        while (itCursos.hasNext()) {
            Curso curso = itCursos.next();
            xmlSerializado += "<curso id=" + "'" + curso.getId() + "'" + " nombre=" + "'" + curso.getNombre() + "'" + ">";
            ListIterator<Asignatura> itAsignaturas = curso.getAsignaturas().listIterator();
            while (itAsignaturas.hasNext()) {
                Asignatura asignatura = itAsignaturas.next();
                xmlSerializado += "<asignatura id=\""  + asignatura.getId() +"\" nombre=\"" + asignatura.getNombre() + "\"/>";
            }
            xmlSerializado += "</curso>";
        }
        xmlSerializado += "</cursos>";
        GestorXML gestorXML = new GestorXML();
        gestorXML.escribirXML(xmlSerializado, "cursos.xml");
    }
}
