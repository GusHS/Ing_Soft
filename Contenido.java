import javax.swing.ImageIcon;

public class Contenido {
    private int idLectura, nDescargas, grado;
    private String estado, texto;
    private ImageIcon imagen;
    private Grupo grupo;

    public Contenido(){
        this.idLectura = 0;
        this.grado = 0;
        this.estado = "";
        this.texto = "";
        this.imagen = new ImageIcon();
        this.grupo = new Grupo();
        this.nDescargas = 0;
    }

    public Contenido(String datos, ImageIcon img, Grupo group){
        String[]sp = datos.split("_");
        this.idLectura = Integer.parseInt(sp[0]);
        this.grado = Integer.parseInt(sp[1]);
        this.estado = sp[2];
        this.titulo= sp[3];
        this.nDescargas = Integer.parseInt(sp[5]);
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
    public String getTexto(){
        return this.texto;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public ImageIcon getImage(){
        return this.imagen;
    }
    public Grupo getGrupo(){
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
    public void setGrupo(Grupo group){
        this.grupo = group;
    }
    public void setDescargas(int desc){
        this.nDescargas = desc;
    }

}