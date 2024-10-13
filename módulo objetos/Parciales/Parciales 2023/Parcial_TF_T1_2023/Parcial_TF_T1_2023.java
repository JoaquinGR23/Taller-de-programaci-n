package parcial_tf_t1_2023; 
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TF_T1_2023 {
    public static void main(String[] args) {
        Director dir = new Director("dir ejecutivo ", 1230, 2020, 12004.23,20.3);
        Empresa em = new Empresa("empresa nueva","dir nueva", dir, 4);
        Encargado en;
        GeneradorAleatorio.iniciar();
        for(int i=0;i<3;i++){
           en = new Encargado(GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarInt(123)+1, GeneradorAleatorio.generarInt(16)+2000, GeneradorAleatorio.generarInt(6)+1, GeneradorAleatorio.generarDouble(1234));
           em.asignarEncargadoAUnaSucursal(i+1, en);
        }      
    
        System.out.println("");
        System.out.println("Representacion interna de la empresa: ");
        System.out.println(em.toString());
    }    
}
