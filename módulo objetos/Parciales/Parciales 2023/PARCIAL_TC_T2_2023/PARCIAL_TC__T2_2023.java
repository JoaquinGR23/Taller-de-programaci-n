package PARCIAL_TC_2023; 
/**
 * @author jGimenezruiz
 */
import  PaqueteLectura.GeneradorAleatorio;
public class PARCIAL_TC_2023 {
    public static void main(String[] args) {
        Estacion es = new Estacion("dir", 12.12, 4); 
        GeneradorAleatorio.iniciar();
        String [] vec ={"debito","credito", "efectivo"};
        //SURTIDOR 1
        for(int i=0;i<4;i++){
           es.agregarVentaASurtidor(1, GeneradorAleatorio.generarInt(5)+1, GeneradorAleatorio.generarInt(5)+1, vec[GeneradorAleatorio.generarInt(3)]);
        }
        //SURTIDOR 2
        for(int i=0;i<4;i++){
           es.agregarVentaASurtidor(2, GeneradorAleatorio.generarInt(5)+1, GeneradorAleatorio.generarInt(5)+1, vec[GeneradorAleatorio.generarInt(3)]);
        }
        //SURTIDOR 3
        for(int i=0;i<4;i++){
           es.agregarVentaASurtidor(3, GeneradorAleatorio.generarInt(5)+1, GeneradorAleatorio.generarInt(5)+1, vec[GeneradorAleatorio.generarInt(3)]);
        }
        //SURTIDOR 4
        for(int i=0;i<4;i++){
           es.agregarVentaASurtidor(4, GeneradorAleatorio.generarInt(5)+1, GeneradorAleatorio.generarInt(5)+1, vec[GeneradorAleatorio.generarInt(3)]);
        }
        //SURTIDOR 5
        for(int i=0;i<4;i++){
           es.agregarVentaASurtidor(5, GeneradorAleatorio.generarInt(5)+1, GeneradorAleatorio.generarInt(5)+1, vec[GeneradorAleatorio.generarInt(3)]);
        }
        //SURTIDOR 6
        for(int i=0;i<4;i++){
           es.agregarVentaASurtidor(6, GeneradorAleatorio.generarInt(5)+1, GeneradorAleatorio.generarInt(5)+1, vec[GeneradorAleatorio.generarInt(3)]);
        }
        System.out.println(es.toString());
        //INCISO B
        System.out.println("fueras de servicios: ");
        es.cantidadMenorAUnValorIngresado(10);
        System.out.println(es.toString());
        
        //INCISO C  
        System.out.println("venta con mayor monto abonado de la estacion: ");
        System.out.println(es.ventaMax().toString());
    } 
}
