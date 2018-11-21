import java.util.LinkedList;
import java.util.List;

public class GrupoDP {
    private List<AlumnoDP> lAlumnos;
    private float avanceGeneral;
    private int grado;

    public GrupoDP(){
        this.lAlumnos = new LinkedList<AlumnoDP>();
        this.avanceGeneral = 0;
        this.grado = 0;
    }

    public GrupoDP(List<AlumnoDP> lAlumn, float av, int grade){
        this.lAlumnos = lAlumn;
        this.avanceGeneral = av;
        this.grado = grade;
    }

    public List<AlumnoDP> getListaAlumnos(){
        return this.lAlumnos;
    }
    public float getAvanceGeneral(){
        return this.avanceGeneral;
    }
    public int getGrado(){
        return this.grado;
    }

    public void setListaAlumnos(List<AlumnoDP> lAlumn){
        this.lAlumnos = lAlumn;
    }
    public void setAvanceGeneral(float avance){
        this.avanceGeneral = avance;
    }
    public void setGrado(int grade){
        this.grado = grade;
    }
}