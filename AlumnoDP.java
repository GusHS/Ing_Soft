public class AlumnoDP {
    private int grado;
    private String nombre, id;
    private float avance;

    public AlumnoDP(){
        this.id = "";
        this.nombre = "";
        this.avance = 0;
        this.grado = 0;
    }
    
    public AlumnoDP(String datos){
        String[] sp = datos.split("_");
        this.id = sp[0];
        this.nombre = sp[1];
        this.avance = Float.parseFloat(sp[2]);
        this.grado = Integer.parseInt(sp[3]);
    }

    public String getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public float getAvance(){
        return this.avance;
    }
    public int getGrado(){
        return this.grado;
    }
    
    public void setId(String i){
        this.id = i;
    }
    public void setNombre(String nom){
        this.nombre = nom;
    }
    public void setAvance(float av){
        this.avance = av;
    }
    public void setGrado(int deg){
        this.grado = deg;
    }
    
}