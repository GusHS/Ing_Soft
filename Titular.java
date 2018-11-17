import java.util.LinkedList;
import java.util.List;

import com.sun.javafx.collections.FloatArraySyncer;

public class Titular {
    private int id;
    private String nombre, tipo;
    private List<Grupo> lGrupos;
    private List<Contenido> lContenidos;
    private float avanceTitular;

    public Titular(){
        this.id = 0;
        this.nombre ="";
        this.tipo = "";
        this.lGrupos = new LinkedList<Grupo>();
        this.lContenidos = new LinkedList<Contenido>();
        this.avanceTitular = 0;
    }

    public Titular(String datos, List<Grupo> lGroups, List<Contenido> lContent){
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
    public List<Grupo> getListaGrupos(){
        return this.lGrupos;
    }
    public List<Contenido> getListaContenidos(){
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
    public void getListaGrupos(List<Grupo> lGroup){
        this.lGrupos = lGroup;
    }
    public void getListaContenidos(List<Contenido> lContent){
        this.lContenidos = lContent;
    }
    
}