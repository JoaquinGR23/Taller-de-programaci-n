package parcial_tb_2022; 
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TB_2022 {
    
    public static void main(String[] args) {
        Torneo tor = new Torneo("torneo X", 11, 6);
        Goleador gol;
        GeneradorAleatorio.iniciar();
        for(int i=0;i<10;i++) {
            gol=new Goleador(GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarInt(6));
            tor.agregarGoleador(i+1, gol);
        }
        gol=new Goleador(GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarString(4)+1, 4);
        tor.agregarGoleador(1, gol);
        gol=new Goleador(GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarInt(6));
        tor.agregarGoleador(3, gol);
        
        System.out.println("obtener goleador con menos goles en la fecha: "); 
        System.out.println(tor.obtenerGoleadorConMenosGoles(3));
        System.out.println("");
        
        System.out.println("cantidad de goleadores en el torneo: "); 
        System.out.println(tor.cantidadDeGoleadoresEnElTorneo());
        System.out.println("");
        
        System.out.println("Representacion del torneo: "); 
        System.out.println(tor.toString());
        System.out.println("");
    }  
}
