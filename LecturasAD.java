//Lineas de a a a son los metodos para cargar imagen, texto ,login y lista de cuentos, para que la tengas mas leve

import java.util.LinkedList;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;

public class LecturasAD{
	private LinkedList listaAlumnos, listaGrupos, listaContenidos, listaVacia, listaTitulares;
	private BufferedReader archivoIn, auxIn;
	private GrupoDP grupo4, grupo5, grupo6;
	private DirectivoDP dir;
	private InstitucionDP ins;
	private AlumnoDP alumn;
	private TitularDP titular;
	private String userType= "null";
	
	public LecturasAD(){		
		listaAlumnos = new LinkedList();
		listaGrupos = new LinkedList();
		listaTitulares = new LinkedList();
		listaVacia = new LinkedList();
		listaContenidos = new LinkedList();

		capturarAlumnos();
		capturarContenidos();
		capturarGrupos();
		capturarTitulares();
		capturarDirectivo();
		capturarInstitucion();
	}

	public Vector getContenido(){
		Vector vect = new Vector<>();
		if (userType.equals("ALUMNO")){
			for (int i = 0; i < listaContenidos.size(); i++) {
				if ((((ContenidoDP)listaContenidos.get(i)).getGrado()) == alumn.getGrado()) {
					vect.add(((ContenidoDP)listaContenidos.get(i)).getTitulo());
				}
			}
		}else if(userType.equals("TITULAR")){
			for (int i = 0; i < listaContenidos.size(); i++) {
				if ((((ContenidoDP)listaContenidos.get(i)).getGrado()) == titular.getGrado()) {
					vect.add(((ContenidoDP)listaContenidos.get(i)).getTitulo());
				}
			}
		}
		return vect;
	}

	public String verificarCredenciales(String username, String password){
		char id[];
		String data[], dataUser[];
		String datos="";
		String respuesta="USUARIO NO LOCALIZADO";
		try {
			archivoIn = new BufferedReader(new FileReader("DataText/Login.txt"));
			while(archivoIn.ready()){
				data = archivoIn.readLine().split("_");
				if (data[0].equals(username)) {
					respuesta ="USUARIO ENCONTRADO";
					if (data[1].equals(password)) {
						respuesta = "VALIDADO";
						id = data[0].toCharArray();
						if(id[0] == 'A'){
							userType = "ALUMNO";
							auxIn = new BufferedReader(new FileReader("DataText/Alumnos.txt"));
							while (auxIn.ready()) {
								datos = auxIn.readLine();
								dataUser = datos.split("_");
								if (dataUser[0].equals(data[0])) {
									alumn = new AlumnoDP(datos);
								}
							}
						}else if (id[0] == 'T') {
							userType = "TITULAR";
							auxIn = new BufferedReader(new FileReader("DataText/Titulares.txt"));
							while (auxIn.ready()) {
								datos = auxIn.readLine();
								dataUser = datos.split("_");
								if (dataUser[0].equals(data[0])) {
									titular = new TitularDP(datos);
									for (int i = 0; i < listaGrupos.size(); i++) {
										if (((GrupoDP)listaGrupos.get(i)).getGrado() == Integer.parseInt(dataUser[4])) {
											titular.getListaGrupos().add((GrupoDP)listaGrupos.get(i));
										}
									}
									for (int i = 0; i < listaContenidos.size(); i++) {
										if (((ContenidoDP)listaContenidos.get(i)).getGrado() == Integer.parseInt(dataUser[4])) {
											titular.getListaContenidos().add((ContenidoDP)listaContenidos.get(i));
										}
									}
								}
							}
						}
						
					}else{
						respuesta = "CONTRASENA INCORRECTA";
					}
				}
			}
			archivoIn.close();
		} catch (Exception e) {
			System.out.print("Exception: "+ e);
		}
		return respuesta;
	}

	// private ImageIcon getImagenCuento(String titulo){
	// 	ImageIcon ret = new ImageIcon();
		
	// 	for(int i=0; i<listaContenidos.size(); i++){
	// 		if((((ContenidoDP)listaContenidos.get(i)).getTitulo()).equals(titulo)){
	// 			ret = ((ContenidoDP)listaContenidos.get(i)).getImage();
	// 		}
	// 	}
	// 	return ret;
	// }
	
	private String getTitulares(String titulo){
		String datos="", res="";
		try{
   			archivoIn = new BufferedReader(new FileReader("DataText/Titulares.txt"));
   			while(archivoIn.ready()){
   				datos = archivoIn.readLine();
   				res = res+datos;
   			}
   			archivoIn.close();
   		}
   		catch(FileNotFoundException fnfe){
   			System.out.println("Error: "+fnfe);
   		}
   		catch(IOException ioe){
   			System.out.println("Error: "+ioe);
   		}
   		
   		return res;
	}
	
	// public LinkedList getCuentos (int grado){
	// 	LinkedList cuentos = new LinkedList();

	// 	for(int i=0; i<listaContenidos.size(); i++){
	// 		if((((ContenidoDP)listaContenidos.get(i)).getGrado()) == grado){
	// 			cuentos.add(((ContenidoDP)listaContenidos.get(i)).getTitulo());
	// 		}
	// 	}	
	// 	return cuentos;
	// }
	
	private void capturarInstitucion(){
		ins =  new InstitucionDP(listaGrupos, listaTitulares, 0, dir);
		
		float prom = totalAverage();
		
		ins.setAvanceInstitucional(prom);
	}
	
	private void capturarDirectivo(){
		String datos="";
		try
   		{
   			// 1. Abrir el archivo de datos
   			archivoIn = new BufferedReader(new FileReader("DataText/Directivo.txt"));
   			
   			// 2. Leer los datos del archivo
   			datos = archivoIn.readLine();
   				
   			dir = new DirectivoDP(datos);
   			
   			
   			// 3. Cerrar archivo
   			archivoIn.close();
   		}
   		catch(FileNotFoundException fnfe)
   		{
   			System.out.println("Error: "+fnfe);
   		}
   		catch(IOException ioe)
   		{
   			System.out.println("Error: "+ioe);
   		}
	}
	
	private void capturarTitulares(){
		String datos="";
		try{
   			archivoIn = new BufferedReader(new FileReader("DataText/Titulares.txt"));
   			while(archivoIn.ready()){
   				datos = archivoIn.readLine();
   				listaTitulares.add(new TitularDP(datos, listaVacia, listaVacia));
   			}
   			archivoIn.close();
   		}
   		catch(FileNotFoundException fnfe){
   			System.out.println("Error: "+fnfe);
   		}
   		catch(IOException ioe){
   			System.out.println("Error: "+ioe);
   		}
   		
   		for(int i=0; i<listaTitulares.size();i++){
			if(((TitularDP)listaTitulares.get(i)).getGrado() == 4){
				(((TitularDP)listaTitulares.get(i)).getListaGrupos()).add(grupo4);
			}
			if(((TitularDP)listaTitulares.get(i)).getGrado() == 5){
				(((TitularDP)listaTitulares.get(i)).getListaGrupos()).add(grupo5);
			}
			if(((TitularDP)listaTitulares.get(i)).getGrado() == 6){
				(((TitularDP)listaTitulares.get(i)).getListaGrupos()).add(grupo5);
			}
		}
		
		for(int i=0; i<listaTitulares.size();i++){
			for(int j=0; j<listaContenidos.size();j++){
				if(((TitularDP)listaTitulares.get(i)).getGrado() == ((ContenidoDP)listaContenidos.get(j)).getGrado()){
					(((TitularDP)listaTitulares.get(i)).getListaContenidos()).add((ContenidoDP)listaContenidos.get(j));
				}
			}
		}
	}
	private void capturarContenidos(){
		String datos[];
		String data ="";
		File pathTexts = new File("Lecturas/");
		String directoryText[] = pathTexts.list();

		for (int i = 0; i < directoryText.length; i++) {
			System.out.println("DIRECTORIES TEXT: "+directoryText[i]);
		}

		File pathImages = new File("Imagenes/");
		String directoryImages[] = pathImages.list();
		for (int i = 0; i < directoryImages.length; i++) {
			System.out.println("DIRECTORIES IMAGES: "+directoryImages[i]);
		}

		try {
			archivoIn = new BufferedReader(new FileReader("DataText/Lecturas.txt"));
			while (archivoIn.ready()){
				data = archivoIn.readLine();
				datos = data.split("_");
				for (int i = 0; i < directoryText.length; i++) { //Busca las Lecturas disponibles.
					if ((datos[3]+".txt").equals(directoryText[i])) { //Verifica que la Lectura sea encontrada
						for (int j = 0; j < directoryImages.length; j++) { //Busca en las imagenes disponibles
							if ((datos[0]+".jpg").equals(directoryImages[j])) { //Verifica que la imagen sea encontrada
								System.out.println("REACHED SWITCH");
								switch (Integer.parseInt(datos[1])) { //Compara el grado.
									case 4:
										listaContenidos.add(new ContenidoDP(data, directoryImages[j], directoryText[i], grupo4));
										System.out.println("ENTERED CASE 4");	
										break;
									case 5:
										listaContenidos.add(new ContenidoDP(data, directoryImages[j], directoryText[i], grupo5));
										System.out.println("ENTERED CASE 5");	
										break;
									case 6:
										listaContenidos.add(new ContenidoDP(data, directoryImages[j], directoryText[i], grupo6));
										System.out.println("ENTERED CASE 6");	
										break;	
									default:
										break;
								}
							}
						}
					}
				}
			} 
		} catch (Exception e) {
			System.out.println("Exception:" +e);
		}
		System.out.println("SUCCESFULLY ENDED"+ listaContenidos.size());			
	}
		
	private void capturarAlumnos(){
		String datos="";
		try {
   			archivoIn = new BufferedReader(new FileReader("DataText/Alumnos.txt"));
   			while(archivoIn.ready()){
   				datos = archivoIn.readLine();
   				listaAlumnos.add(new AlumnoDP(datos));
   			}
   			archivoIn.close();
   		}
   		catch(FileNotFoundException fnfe){
   			System.out.println("Error: "+fnfe);
   		}
   		catch(IOException ioe){
   			System.out.println("Error: "+ioe);
   		}
   		for(int i=0;i<listaAlumnos.size();i++){
   			System.out.println("CAPTURAR ALUMNOS"+((AlumnoDP)listaAlumnos.get(i)).getId());
   		}
	}
	
	private void capturarGrupos(){
		grupo4 = new GrupoDP();
		grupo5 = new GrupoDP();
		grupo6 = new GrupoDP();

		grupo4.setGrado(4);
		grupo5.setGrado(5);
		grupo6.setGrado(6);
		
		for(int i=0; i<listaAlumnos.size();i++){
			if(((AlumnoDP)listaAlumnos.get(i)).getGrado() == 4){
				grupo4.getListaAlumnos().add((AlumnoDP)listaAlumnos.get(i));
			}
			if(((AlumnoDP)listaAlumnos.get(i)).getGrado() == 5){
				grupo5.getListaAlumnos().add((AlumnoDP)listaAlumnos.get(i));
			}
			if(((AlumnoDP)listaAlumnos.get(i)).getGrado() == 6){
				grupo6.getListaAlumnos().add((AlumnoDP)listaAlumnos.get(i));
			}
		}

		grupo4.setAvanceGeneral(groupAverage(grupo4));
		grupo5.setAvanceGeneral(groupAverage(grupo5));
		grupo6.setAvanceGeneral(groupAverage(grupo6));
		
		listaGrupos.add(grupo4);
		listaGrupos.add(grupo5);
		listaGrupos.add(grupo6);
	}
	
	private float groupAverage(GrupoDP calc){
		float av=0;
		for(int i=0;i<(calc.getListaAlumnos()).size();i++){
   			av = av + (((calc.getListaAlumnos()).get(i)).getAvance());
   		}
   		av = av/((calc.getListaAlumnos()).size());
   		return av;
	}
	
	private float titularAverage(){
		float av = 0;
		for(int i=0; i<listaTitulares.size(); i++){
			av += ((TitularDP)listaTitulares.get(i)).getAvanceTitular();
		}
		av = av/(listaTitulares.size());

		return av;
	}
	
	private float totalAverage(){
		float aver = (groupAverage(grupo4) + groupAverage(grupo5) + groupAverage(grupo6) + titularAverage())/4;
		return aver;
	}
	public LinkedList getListaContenido(){
		return this.listaContenidos;
	}
}