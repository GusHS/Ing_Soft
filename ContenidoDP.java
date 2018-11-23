import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;

public class ContenidoDP {
    private int nDescargas, grado;
    private String estado, idLectura, titulo, texto;
    private ImageIcon imagen;
    private GrupoDP grupo;
    private BufferedReader archivoIn;
    private ImageIcon imageIcon;

    public ContenidoDP(){
        this.idLectura = "";
        this.grado = 0;
        this.estado = "";
        this.titulo = "";
        this.texto = "";
        this.imagen = new ImageIcon();
        this.grupo = new GrupoDP();
        this.nDescargas = 0;
    }

    public ContenidoDP(String datos, String imagePath, String textPath, GrupoDP group){
        String[]sp = datos.split("_");
        String txt="";
        try {
            archivoIn = new BufferedReader(new InputStreamReader(new FileInputStream("Lecturas/"+textPath),"UTF-8"));
            while (archivoIn.ready()) {
                txt += archivoIn.readLine()+"\n";
            }
            archivoIn.close();            
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        this.idLectura = sp[0];
        this.grado = Integer.parseInt(sp[1]);
        this.estado = sp[2];
        this.titulo= sp[3];
        this.texto = txt;
        this.nDescargas = Integer.parseInt(sp[4]);
        this.imagen = new ImageIcon(((new ImageIcon("Imagenes/"+imagePath)).getImage()).getScaledInstance(218, 218, java.awt.Image.SCALE_SMOOTH));;
        this.grupo = group;
    }

    public String getIdLectura(){
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
    public String getTexto(){
        return this.texto;
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
    public int addDescarga(){
        this.nDescargas++;
        return this.nDescargas;
    }

    public void setIdLectura(String num){
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
    public void setTexto(String text){
        this.titulo = text;
    }
    public void setImage(ImageIcon img){
        this.imagen = img;
    }
    public void setGrupo(GrupoDP group){
        this.grupo = group;
    }
    public void setDescargas(int desc){
        this.nDescargas = desc;
    }

}