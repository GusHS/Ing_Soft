public class Titular {
    private int id;
    private String nombre, tipo;
    private List<Grupo> listaGrupo;
    private List<Contenidos> listaContenidos;
    private float avanceTitular;
    private Institucion institucion;

    public Titular(String datos){
        String[] sp = datos.split("_");
        id = Integer.parseInt(sp[0]);
        nombre = sp[1].toUpperCase();
        tipo = sp[2].toUpperCase();
    }
    
}