import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class LecturasAD {
    private BufferedReader archivoIn;
    private LinkedList listaAlumnos;

    public LecturasAD(){
        capturarAlumnos();
        System.out.println(desplegarAlumnos());
    }
    private void capturarAlumnos(){
        String datos ="";
        try {
            archivoIn = new BufferedReader(new FileReader("Alumnos.txt"));
            while (archivoIn.ready()) {
                datos = archivoIn.readLine();
                listaAlumnos.add(new AlumnoDP(datos));
            }
        } catch (Exception e) {
            System.out.println("Exception: "+e);
        }
    }
    private String desplegarAlumnos(){
        String datos="";
        for (int i = 0; i < listaAlumnos.size(); i++) {
           datos += listaAlumnos.get(i)+"\n"; 
        }
        return datos;
    }  
}