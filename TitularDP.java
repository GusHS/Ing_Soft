import java.util.LinkedList;
import java.util.List;

public class TitularDP {
    private int id;
    private String nombre, tipo;
    private List<GrupoDP> lGrupos;
    private List<ContenidoDP> lContenidos;
    private float avanceTitular;

    public TitularDP(){
        this.id = 0;
        this.nombre ="";
        this.tipo = "";
        this.lGrupos = new LinkedList<GrupoDP>();
        this.lContenidos = new LinkedList<ContenidoDP>();
        this.avanceTitular = 0;
    }

    public TitularDP(String datos, List<GrupoDP> lGroups, List<ContenidoDP> lContent){
        String sp[] = datos.split("_");
        this.id = Integer.parseInt(sp[0]);
        this.nombre = sp[1];
        this.tipo = sp[2];
        this.avanceTitular = Float.parseFloat(sp[3]);
        this.lGrupos = lGroups;
        this.lContenidos = lContent;
    }

    public int getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getTipo(){
        return this.tipo;
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

    public void setId(int num){
        this.id = num;
    }
    public void getNombre(String nom){
        this.nombre = nom;
    }
    public void getTipo(String type){
        this.tipo = type;
    }
    public void getAvanceTitular(float av){
        this.avanceTitular = av;
    }
    public void getListaGrupos(List<GrupoDP> lGroup){
        this.lGrupos = lGroup;
    }
    public void getListaContenidos(List<ContenidoDP> lContent){
        this.lContenidos = lContent;
    }
    
}