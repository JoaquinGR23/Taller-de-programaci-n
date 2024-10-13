package parcial_td_2023; 
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TD_2023 {
    public static void main(String[] args) {
       Estacionamiento es= new Estacionamiento("dir estacionamiento", 4, 5, 34.20);
        Vehiculos v;
        GeneradorAleatorio.iniciar();
        for(int i=0;i<4;i++) {
            v = new Vehiculos(GeneradorAleatorio.generarInt(234)+1, GeneradorAleatorio.generarInt(4)+1, GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarString(5)+1);
            es.registrarVehiculo(v, i+1, i+1);
        }
        
         v = new Vehiculos(GeneradorAleatorio.generarInt(234)+1, GeneradorAleatorio.generarInt(4)+1, "toyota", GeneradorAleatorio.generarString(5)+1);
         es.registrarVehiculo(v, 1, 2);  
         v = new Vehiculos(GeneradorAleatorio.generarInt(234)+1, GeneradorAleatorio.generarInt(4)+1, "toyota", GeneradorAleatorio.generarString(5)+1);
         es.registrarVehiculo(v, 3, 2);  
         
         
         System.out.println("Liberar espacio: ");
         System.out.println(es.liberarEspacioDeUnSectorParticular(3,"toyota" ));
         System.out.println("");
         
         System.out.println("Sector con mas recaudacion de la estacion");
         System.out.println(es.sectorConMasRecaudacionDeLaEstacion());
         System.out.println("");
         
         System.out.println("Rep:");
         System.out.println(es.toString());
         System.out.println("");
    }  
}
