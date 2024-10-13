package parcial_te_2023; 
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TE_2023 {

    public static void main(String[] args) {
       Tradicional t = new Tradicional(30);
       Digital d = new Digital("dir web", 10);
       Cuenta c;
           c = new Cuenta(GeneradorAleatorio.generarString(12)+1, "dolar", 123, GeneradorAleatorio.generarInt(2344)+1);
           t.agregarCuenta(c);
           c = new Cuenta(GeneradorAleatorio.generarString(12)+1, "dolar", 124, GeneradorAleatorio.generarInt(2344)+1);
           t.agregarCuenta(c);
           c = new Cuenta(GeneradorAleatorio.generarString(12)+1, "dolar", 125, GeneradorAleatorio.generarInt(2344)+1);
           t.agregarCuenta(c);
           
           c = new Cuenta(GeneradorAleatorio.generarString(12)+1, "pesos", 126, GeneradorAleatorio.generarInt(2344)+1);
           d.agregarCuenta(c);
           c = new Cuenta(GeneradorAleatorio.generarString(12)+1, "dolar", 127, GeneradorAleatorio.generarInt(2344)+1);
           d.agregarCuenta(c);
           c = new Cuenta(GeneradorAleatorio.generarString(12)+1, "dolar", 128, GeneradorAleatorio.generarInt(2344)+1);
           d.agregarCuenta(c);
       
        System.out.println("depositar dinero: ");
        t.depositarDinero(124, 123.23+300);
        System.out.println("");
        
        System.out.println("depositar dinero: ");
        d.depositarDinero(126, 124.23+100000);
        System.out.println("");
        
        System.out.println("recibir tarjeta BANCO TRADICIONAL: "+t.puedeRecibirTarjeta(124));
        System.out.println("recibir tarjeta BANCO Digital: "+d.puedeRecibirTarjeta(126));
        
    } 
    
}
