package parcial_tn_2024;
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TN_2024 {

    public static void main(String[] args) {
        Medico m = new Medico("neurologo", 123, "lotoki", "Adolfo", 666, 0303456);
        Consultorio c = new Consultorio("DR chapatin", "AV siempreViva", m, 10);
        Paciente p;
        
        GeneradorAleatorio.iniciar();;
        for(int i=0;i<5;i++){
            p = new Paciente(GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarString(7)+1, GeneradorAleatorio.generarString(8)+1, GeneradorAleatorio.generarInt(8)+133, GeneradorAleatorio.generarInt(8)+21);
            c.asignarTurno(p, GeneradorAleatorio.generarInt(10)+1, i+1);
        }
        p = new Paciente("Obra social OSDE", GeneradorAleatorio.generarString(7)+1, GeneradorAleatorio.generarString(8)+1, GeneradorAleatorio.generarInt(8)+133, GeneradorAleatorio.generarInt(8)+21);
        c.asignarTurno(p, GeneradorAleatorio.generarInt(10)+1, 3);
        
        p = new Paciente("Obra social OSDE", GeneradorAleatorio.generarString(7)+1, GeneradorAleatorio.generarString(8)+1, GeneradorAleatorio.generarInt(8)+133, GeneradorAleatorio.generarInt(8)+21);
        c.asignarTurno(p, GeneradorAleatorio.generarInt(10)+1, 5);
        
        p = new Paciente("Obra social OSECAC", GeneradorAleatorio.generarString(7)+1, GeneradorAleatorio.generarString(8)+1, GeneradorAleatorio.generarInt(8)+133, GeneradorAleatorio.generarInt(8)+21);
        c.asignarTurno(p, GeneradorAleatorio.generarInt(10)+1, 4);
   
        System.out.println("Cantidad de pacientes con obra social OSDE");
        System.out.println(c.cantidadDePacientesConObraSocialIngresada("Obra social OSDE"));
        System.out.println("");
        
        System.out.println("Cantidad de pacientes con obra social OSECAC");
        System.out.println(c.cantidadDePacientesConObraSocialIngresada("Obra social OSECAC"));
        System.out.println("");
        
        System.out.println("Representacion: ");
        System.out.println(c.toString());
        System.out.println("");
  
    }
}
