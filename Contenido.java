import javax.swing.ImageIcon;

public class Contenido {
    private int idLectura, nDescargas;
    private String estado, texto;
    private ImageIcon imagen;
    private Grupo grupo;

    public Contenido(){
        this.idLectura = 0;
        this.estado = "";
        this.texto = "";
        this.imagen = new ImageIcon();
        this.grupo = new Grupo();
        this.nDescargas = 0;
    }

    public Contenido(String datos, ImageIcon img, Grupo group){
        String[]sp = datos.split("_");
        this.idLectura = Integer.parseInt(sp[0]);
        this.estado = sp[1];
        this.texto = sp[2];
        this.nDescargas = Integer.parseInt(sp[3]);
        this.imagen = img;
        this.grupo = group;
    }

    public int getIdLectura(){
        return this.idLectura;
    }
    public String getEstado(){
        return this.estado;
    }
    public String getTexto(){
        return this.texto;
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
    public void setEstado(String status){
        this.estado = status;
    }
    public void setTexto(String txt){
        this.texto = txt;
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