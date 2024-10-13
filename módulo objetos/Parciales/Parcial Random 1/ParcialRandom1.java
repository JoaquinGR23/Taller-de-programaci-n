package parcial.random.pkg1; 
/*
 * @author jGimenezruiz 
 */
import PaqueteLectura.GeneradorAleatorio;
public class ParcialRandom1 {
    public static void main(String[] args) {
        Concurso c = new Concurso(20);
        Alumno alu; 
        alu=new Alumno(GeneradorAleatorio.generarInt(23)+10, GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarString(5)+1);
        c.agregarAlumno(1,alu);
        
         alu=new Alumno(GeneradorAleatorio.generarInt(23)+10, GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarString(5)+1);
        c.agregarAlumno(2,alu);
        
         alu=new Alumno(GeneradorAleatorio.generarInt(23)+10, GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarString(5)+1);
        c.agregarAlumno(3,alu);
        
         alu=new Alumno(GeneradorAleatorio.generarInt(23)+10, GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarString(5)+1);
        c.agregarAlumno(4,alu);
        
    }
    
}
