package parcial_tb_t1_2023; 
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TB_T1_2023 {
    public static void main(String[] args) {
       Aula X = new Aula("Aula X- FORTRAN", 150);
        Aula Y = new Aula("Aula 11- JAVA", 150);
        Examen ex = new Examen(X, Y);
        ex.setFecha("18/10/2023");
        Alumno alu;
        GeneradorAleatorio.iniciar();
        for(int i=0;i<4;i++){
            alu = new Alumno(GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarInt(123)+1);
            System.out.println(ex.agregarAlumnoAlExamen(alu));
        }
        alu = new Alumno("peres", "jose", 123);
        System.out.println(ex.agregarAlumnoAlExamen(alu));
        ex.asignarNota(10, 123);
        
        System.out.println("REP:");
        System.out.println(ex.toString());
        System.out.println("");
    }  
}
