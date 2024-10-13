package parcial_tf_2024;
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TF_2024 {
    
    public static void main(String[] args) {
        Libreria l = new Libreria("nom X", 6);
        Ticket t;
        String []v={"debito","credito", "efectivo"};
        GeneradorAleatorio.iniciar();
        for(int j=0;j<3;j++){
          for(int i=0;i<4;i++){
              l.generarYAgregarTicket(j+1, GeneradorAleatorio.generarInt(522)+545, GeneradorAleatorio.generarInt(10)+1, GeneradorAleatorio.generarDouble(2200)+31.20, v[GeneradorAleatorio.generarInt(3)]);
          }
          if(j+1==2){//para generar 2 tickets mas en la caja 2
              l.generarYAgregarTicket(j+1, GeneradorAleatorio.generarInt(522)+545, GeneradorAleatorio.generarInt(10)+1, GeneradorAleatorio.generarDouble(2200)+31.20, v[GeneradorAleatorio.generarInt(3)]);
          }
          if(j+1==3){ //para generar 2 tickets mas en la caja 3
              l.generarYAgregarTicket(j+1, GeneradorAleatorio.generarInt(522)+545, GeneradorAleatorio.generarInt(10)+1, GeneradorAleatorio.generarDouble(2200)+31.20, v[GeneradorAleatorio.generarInt(3)]);
              l.generarYAgregarTicket(j+1, GeneradorAleatorio.generarInt(522)+545, GeneradorAleatorio.generarInt(10)+1, GeneradorAleatorio.generarDouble(2200)+31.20, v[GeneradorAleatorio.generarInt(3)]);
          }
        }
        
        System.out.println("Representacion antes del cambio: ");
        System.out.println(l.toString());
        System.out.println("");
        
        System.out.println("cambio de disponibilidad:");
        l.cambiarDisponibilidad(35);
        System.out.println("");
        
        System.out.println("Representacion despues del cambio: ");
        System.out.println(l.toString());
        System.out.println("");
        
        System.out.println("datos del ticket con mayor monto abonado de la libreria: ");
        System.out.println(l.ticketConMayorMontoAbonado().toString());
        System.out.println("");
    }   
}
