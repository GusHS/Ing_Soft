import java.util.LinkedList;
import java.util.List;

public class GrupoDP {
    private List<AlumnoDP> lAlumnos;
    private float avanceGeneral;

    public GrupoDP(){
        this.lAlumnos = new LinkedList<AlumnoDP>();
        this.avanceGeneral = 0;
    }

    public GrupoDP(List<AlumnoDP> lAlumn, float av){
        this.lAlumnos = lAlumn;
        this.avanceGeneral = av;
    }

    public List<AlumnoDP> getListaAlumnos(){
        return this.lAlumnos;
    }
    public float getAvanceGeneral(){
        return this.avanceGeneral;
    }

    public void setListaAlumnos(List<AlumnoDP> lAlumn){
        this.lAlumnos = lAlumn;
    }
    public void setAvanceGeneral(float avance){
        this.avanceGeneral = avance;
    }
}