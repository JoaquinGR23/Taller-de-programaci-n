package parcial_te_2024;
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TE_2024 {

    public static void main(String[] args) {
        Supermercado s = new Supermercado("dir del supermercado");
        Caja c;
        String []v={"debito","credito","efectivo"};
        
        GeneradorAleatorio.iniciar();
        
        for(int i=0;i<4;i++){
            c= new Caja("cajero "+(i+1), i+4);
            s.agregarCaja(c);

            s.agregarTicketDeCompra(i+1, GeneradorAleatorio.generarInt(456)+1235, GeneradorAleatorio.generarInt(10)+1, GeneradorAleatorio.generarDouble(1000)+450.55, v[GeneradorAleatorio.generarInt(3)]);
        }
        s.agregarTicketDeCompra(1, GeneradorAleatorio.generarInt(456)+1235, GeneradorAleatorio.generarInt(10)+1, GeneradorAleatorio.generarDouble(1000)+450.55, v[GeneradorAleatorio.generarInt(3)]);
        s.agregarTicketDeCompra(1, GeneradorAleatorio.generarInt(456)+1235, GeneradorAleatorio.generarInt(10)+1, GeneradorAleatorio.generarDouble(1000)+450.55, v[GeneradorAleatorio.generarInt(3)]);
        s.agregarTicketDeCompra(3, GeneradorAleatorio.generarInt(456)+1235, GeneradorAleatorio.generarInt(10)+1, GeneradorAleatorio.generarDouble(1000)+450.55, v[GeneradorAleatorio.generarInt(3)]);
        
        System.out.println("NRO de caja con menor cantidad de tickets: ");
        System.out.println(s.numCajaConMenorCantidadDeTicket());
        System.out.println("");
        
        System.out.println("Representacion : ");
        System.out.println(s.toString());
        System.out.println("");
        System.out.println("");
    }
}
