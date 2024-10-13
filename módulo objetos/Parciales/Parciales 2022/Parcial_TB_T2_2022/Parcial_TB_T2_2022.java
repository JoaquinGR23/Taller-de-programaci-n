package parcial_tb_t2_2022; 
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TB_T2_2022 {

    public static void main(String[] args) {
        Barrio em = new Barrio("Los teros", 6, 9);
       Comprador c;
       GeneradorAleatorio.iniciar();
    
       for(int i=0;i<5;i++){
           c = new Comprador(GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarInt(234)+1);
           em.agregarComprador(c, i+1, i+1);
       }
       c = new Comprador(GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarInt(234)+1);
       em.agregarComprador(c, 2, 3);
       
        System.out.println("incremento el 20%: ");
        em.incrementarPrecioALotes(2, 20);
        System.out.println("");
        
        System.out.println("Rep");
        System.out.println(em.toString());
        System.out.println("");
    }
}
