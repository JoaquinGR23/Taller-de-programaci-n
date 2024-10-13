package parcial_tc_t1_2023; 
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TC_T1_2023 {
    public static void main(String[] args) {
        Estacion es= new Estacion("dir estacion");
        Surtidor sur;
        GeneradorAleatorio.iniciar();
        for(int i=0;i<4;i++){
            sur= new Surtidor(GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarDouble(55)+43.23, 6);
            es.agregarSurtidor(sur);
        }
        for(int i=0;i<3;i++){         
            es.agregarVentaAlSurtidor(i+1, GeneradorAleatorio.generarInt(2233)+1, GeneradorAleatorio.generarInt(9)+1,  GeneradorAleatorio.generarString(4)+1);
        }
        for(int i=0;i<3;i++){         
            es.agregarVentaAlSurtidor(i+1, GeneradorAleatorio.generarInt(2233)+1, GeneradorAleatorio.generarInt(9)+1,  GeneradorAleatorio.generarString(4)+1);
        }
        for(int i=0;i<3;i++){         
            es.agregarVentaAlSurtidor(i+1, GeneradorAleatorio.generarInt(2233)+1, GeneradorAleatorio.generarInt(9)+1,  GeneradorAleatorio.generarString(4)+1);
        }
        es.agregarVentaAlSurtidor(3, GeneradorAleatorio.generarInt(2233)+1, GeneradorAleatorio.generarInt(9)+1,  "efectivo");

        
        System.out.println("surtidor con mayor monto entre sus ventas: ");
        System.out.println(es.surtidorConMayorMontoEntreSusVentas());
        System.out.println("");
        
        
        System.out.println("Rep: ");
        System.out.println(es.toString());
        System.out.println("");
    }   
}
