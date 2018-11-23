public class DirectivoDP
{
	// Atributos
	private String id, nombre;
	
	//Constructores
	public DirectivoDP(){
		this.id 	= "";
		this.nombre = "";
	}
	
	public DirectivoDP(String datos){
		String[] sp = datos.split("_");        
		this.id = sp[0];
		this.nombre = sp[1];
	}
	public String getId(){
		return this.id;
	}
	public String getNombre(){
		return this.nombre;
	}
	
	public void setId(String i){
        this.id = i;
    }
    public void setNombre(String nom){
        this.nombre = nom;
	}
	
    public String toString(){
        return id+nombre;
	}
}