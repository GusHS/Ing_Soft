import javax.swing.ImageIcon;

public class ContenidoDP {
    private int idLectura, nDescargas, grado;
    private String estado, titulo;
    private ImageIcon imagen;
    private GrupoDP grupo;

    public ContenidoDP(){
        this.idLectura = 0;
        this.grado = 0;
        this.estado = "";
        this.titulo = "";
        this.imagen = new ImageIcon();
        this.grupo = new GrupoDP();
        this.nDescargas = 0;
    }

    public ContenidoDP(String datos, ImageIcon img, GrupoDP group){
        String[]sp = datos.split("_");
        this.idLectura = Integer.parseInt(sp[0]);
        this.grado = Integer.parseInt(sp[1]);
        this.estado = sp[2];
        this.titulo= sp[3];
        this.nDescargas = Integer.parseInt(sp[4]);
        this.imagen = img;
        this.grupo = group;
    }

    public int getIdLectura(){
        return this.idLectura;
    }
    public int getGrado(){
        return this.grado;
    }
    public String getEstado(){
        return this.estado;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public ImageIcon getImage(){
        return this.imagen;
    }
    public GrupoDP getGrupo(){
        return this.grupo;
    }
    public int getDescargas(){
        return this.nDescargas;
    }

    public void setIdLectura(int num){
        this.idLectura = num;
    }
    public void setGrado(int deg){
        this.grado = deg;
    }
    public void setEstado(String status){
        this.estado = status;
    }
    public void setTitulo(String title){
        this.titulo = title;
    }
    public void getImage(ImageIcon img){
        this.imagen = img;
    }
    public void setGrupo(GrupoDP group){
        this.grupo = group;
    }
    public void setDescargas(int desc){
        this.nDescargas = desc;
    }

}