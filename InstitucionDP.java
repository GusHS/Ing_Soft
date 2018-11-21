import java.util.List;
import java.util.LinkedList;

public class InstitucionDP {
    private List<GrupoDP> lGrupos;
    private List<TitularDP> lTitulares;
    private float avanceInstitucional;

    public InstitucionDP(){
        this.lGrupos = new LinkedList<GrupoDP>();
        this.lTitulares = new LinkedList<TitularDP>();
        this.avanceInstitucional = 0;
    }

    public InstitucionDP(List<GrupoDP> listaGroups, List<TitularDP> listaTitulares, float av){
        this.lGrupos = listaGroups;
        this.lTitulares = listaTitulares;
        this.avanceInstitucional = av;
    }

    public List<GrupoDP> getListaGrupo(){
        return this.lGrupos;
    }
    public List<TitularDP> getListaTitulares(){
        return this.lTitulares;
    }
    public float getAvanceInstitucional(){
        return this.avanceInstitucional;
    }

    public void setListaGrupo(List<GrupoDP> lGroups){
        this.lGrupos = lGroups;
    }
    public void setListaTitulares(List<TitularDP> listaTitulares){
        this.lTitulares = listaTitulares;
    }
    public void setAvanceInstitucional(float av){
        this.avanceInstitucional = av;
    }
    
}