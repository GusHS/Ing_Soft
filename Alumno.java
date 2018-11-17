public class Alumno {
    private int id, grado;
    private String nombre;
    private float avance;

    public Alumno(){
        this.id = 0;
        this.nombre = "";
        this.avance = 0.0;
        this.grado = 0;
    }
    public Alumno(String datos){
        String[] sp = datos.split("_");
        this.id = Integer.parseInt(sp[0]);
        this.nombre = sp[1];
        this.avance = Float.parseFloat(sp[2]);
        this.grado = Integer.parseInt(sp[3]);
    }

    public int getId(){
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

    public void setId(int i){
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