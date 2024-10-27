package parcial_ta_2024;
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TA_2024 {

    public static void main(String[] args) {
        Sala sala1 = new Sala("unica sala", 1234);
        SalaRestringida sala2 = new SalaRestringida("Vamos_Que_Se_Aprueba_objetos", "unica sala", 1234);
        Participante p;
        GeneradorAleatorio.iniciar();
        for(int i=0;i<5;i++){
            p = new Participante(GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarString(5)+1);
            sala1.agregarParticipante(p);
            p = new Participante(GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarString(5)+1);
            sala2.agregarParticipante(p);
        }
        
        p = new Participante(GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarString(5)+1, "Vamos_Que_Se_Aprueba_objetos");
        sala2.agregarParticipante(p);
        
        System.out.println("resumen sala1: ");
        System.out.println(sala1.resumen());
        System.out.println("");
        
        System.out.println("resumen sala2");
        System.out.println(sala2.resumen());
        System.out.println("");
    }
}
