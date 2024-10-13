package tema1;
/**
 *
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class ejer5 {
    public static void main(String[] args) {
        int fil=5, col=4, suma;
        int[][] m = new int[fil][col];
      GeneradorAleatorio.iniciar();
      for(int i=0;i<fil;i++){
        for(int j=0;j<col;j++) m[i][j]=GeneradorAleatorio.generarInt(10)+1;
      }
      int k;
      for(int i=0;i<fil;i++){
          k=i+1;
          for(int j=0;j<col;j++) System.out.print("| aspecto "+j+" del cliente "+k+ " tiene el puntaje "+m[i][j]);
          System.out.println("|");
      }
      for(int i=0;i<col;i++){
          suma=0;
          for(int j=0;j<fil;j++) suma=suma+m[j][i];
        System.out.println("promedio obtenido del aspecto "+i+" es "+(double)suma/5);
      }   
    }
}
