import java.util.LinkedList;
import java.util.List;

public class Grupo {
    private List<Alumno> lAlumnos;
    private float avanceGeneral;

    public Grupo(){
        this.lAlumnos = new LinkedList<Alumno>();
        this.avanceGeneral = 0;
    }

    public Grupo(List<Alumno> lAlumn, float av){
        this.lAlumnos = lAlumn;
        this.avanceGeneral = av;
    }

    public List<Alumno> getListaAlumnos(){
        return this.lAlumnos;
    }
    public float getAvanceGeneral(){
        return this.avanceGeneral;
    }

    public void setListaAlumnos(List<Alumno> lAlumn){
        this.lAlumnos = lAlumn;
    }
    public void setAvanceGeneral(float avance){
        this.avanceGeneral = avance;
    }
}