import java.util.LinkedList;
import java.util.List;

public class TitularDP {
    private int grado;
    private String nombre, tipo, id;
    private List<GrupoDP> lGrupos;
    private List<ContenidoDP> lContenidos;
    private float avanceTitular;

    public TitularDP(){
        this.id = "";
        this.grado = 0;
        this.nombre ="";
        this.tipo = "";
        this.lGrupos = new LinkedList<GrupoDP>();
        this.lContenidos = new LinkedList<ContenidoDP>();
        this.avanceTitular = 0;
    }

    public TitularDP(String datos, List<GrupoDP> lGroups, List<ContenidoDP> lContent){
        String sp[] = datos.split("_");
        this.id = sp[0];
        this.nombre = sp[1];
        this.tipo = sp[2];
        this.avanceTitular = Float.parseFloat(sp[3]);
        this.grado = Integer.parseInt(sp[4]);
        this.lGrupos = lGroups;
        this.lContenidos = lContent;
    }
    public TitularDP(String datos){
        String sp[] = datos.split("_");
        this.id = sp[0];
        this.nombre = sp[1];
        this.tipo = sp[2];
        this.avanceTitular = Float.parseFloat(sp[3]);
        this.grado = Integer.parseInt(sp[4]);
        this.lGrupos = new LinkedList<GrupoDP>();
        this.lContenidos = new LinkedList<ContenidoDP>();
    }

    public String getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getTipo(){
        return this.tipo;
    }
    public int getGrado(){
    	return this.grado;
    }
    public float getAvanceTitular(){
        return this.avanceTitular;
    }
    public List<GrupoDP> getListaGrupos(){
        return this.lGrupos;
    }
    public List<ContenidoDP> getListaContenidos(){
        return this.lContenidos;
    }

    public void setId(String num){
        this.id = num;
    }
    public void setNombre(String nom){
        this.nombre = nom;
    }
    public void setTipo(String type){
        this.tipo = type;
    }
    public void setGrado(int g){
    	this.grado = g;
    }
    public void setAvanceTitular(float av){
        this.avanceTitular = av;
    }
    public void setListaGrupos(List<GrupoDP> lGroup){
        this.lGrupos = lGroup;
    }
    public void getListaContenidos(List<ContenidoDP> lContent){
        this.lContenidos = lContent;
    }
    
}