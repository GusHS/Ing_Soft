import java.util.List;

public class Grupo {
    private List<Alumno> lAlumnos;
    private float avanceGeneral;

    public Grupo(){
        this.lAlumnos = new List<Alumno>();
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

    public void setListaAlumnos(Lista<Alumno> lAlumn){
        this.lAlumnos = lAlumn;
    }
    public void setAvanceGeneral(float avance){
        this.avanceGeneral = avance;
    }
}