package parcial_th_2023; 
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TH_2023 {
    public static void main(String[] args) {
        Estadio es= new Estadio("estadio ", "Dir estadio");
       Concierto c;
       GeneradorAleatorio.iniciar();
       for(int i=0;i<5;i++){
           c = new Concierto(GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarDouble(12)+24.34, GeneradorAleatorio.generarInt(12)+1);
           es.registrarConcierto(i+1, c);
       }
       c = new Concierto(GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarDouble(12)+24.34, GeneradorAleatorio.generarInt(12)+1);
       es.registrarConcierto(1, c);
       
       c = new Concierto(GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarDouble(12)+24.34, GeneradorAleatorio.generarInt(12)+1);
       es.registrarConcierto(7, c);
           
       c = new Concierto(GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarDouble(12)+24.34, GeneradorAleatorio.generarInt(12)+1);
       es.registrarConcierto(12, c);
         
        System.out.println("conciertos del mes ingresado: ");
        System.out.println(es.listaDeConciertosDelMesIngresado(1));
        System.out.println("");
        
        System.out.println("Ganancia del mes ingresado: ");
        System.out.println(es.calcularGananciaEnElMesIngresado(1));
        System.out.println("");
        
        System.out.println("Rep: ");
        System.out.println(es.toString());
        System.out.println("");
    }
}
 