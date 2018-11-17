import java.util.List;
import java.util.LinkedList;

public class Institucion {
    private List<Grupo> lGrupos;
    private List<Titular> lTitulares;
    private float avanceInstitucional;

    public Institucion(){
        this.lGrupos = new LinkedList<Grupo>();
        this.lTitulares = new LinkedList<Titular>();
        this.avanceInstitucional = 0;
    }

    public Institucion(List<Grupo> listaGroups, List<Titular> listaTitulares, float av){
        this.lGrupos = listaGroups;
        this.lTitulares = listaTitulares;
        this.avanceInstitucional = av;
    }

    public List<Grupo> getListaGrupo(){
        return this.lGrupos;
    }
    public List<Titular> getListaTitulares(){
        return this.lTitulares;
    }
    public float getAvanceInstitucional(){
        return this.avanceInstitucional;
    }

    public void setListaGrupo(List<Grupo> lGroups){
        this.lGrupos = lGroups;
    }
    public void setListaTitulares(List<Titular> listaTitulares){
        this.lTitulares = listaTitulares;
    }
    public void setAvanceInstitucional(float av){
        this.avanceInstitucional = av;
    }
    
}