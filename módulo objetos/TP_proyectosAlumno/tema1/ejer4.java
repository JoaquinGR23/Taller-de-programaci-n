package tema1;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author jGimenezRuiz
 */
public class ejer4 {  
    public static void main(String[] args) {
        int fil=8,col=4, num1,num2=-1;
        int [][] edificio = new int [fil][col];
        
        GeneradorAleatorio.iniciar();             
        
        System.out.println("ingrese el piso: ");
           num1=GeneradorAleatorio.generarInt(9);
           if(num1!=8){
               System.out.println("ingrese la oficina: ");
               num2=GeneradorAleatorio.generarInt(4);
           }
        while(num1!=8){
           edificio[num1][num2]++;
           System.out.println("ingrese el piso: ");
           num1=GeneradorAleatorio.generarInt(9);
           if(num1!=8){
               System.out.println("ingrese la oficina: ");
               num2=GeneradorAleatorio.generarInt(4);
           }
        }
        for(int i=0;i<fil;i++){           
            for(int j=0;j<col;j++){
                System.out.print("| "+edificio[i][j]+" | ");
            }
            System.out.println();
        }
    }    
}
