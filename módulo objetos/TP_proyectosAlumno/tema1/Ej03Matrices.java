
package tema1;

//Paso 1. importar la funcionalidad para generar datos aleatorios
import PaqueteLectura.GeneradorAleatorio;

public class Ej03Matrices {
    public static void main(String[] args) {
	//Paso 2. iniciar el generador aleatorio     
	 GeneradorAleatorio.iniciar();
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        int fil=5,col=5, suma,df=5,filaNueva, num,filaDelNum=-1,colDelNum=-1;
        int [][] m = new int[fil][col];
        int [] v = new int [df]; 
        boolean encontre=false;
        
        for (int i=0;i<fil;i++){
          for(int j=0;j<col;j++){
              m[i][j]=GeneradorAleatorio.generarInt(31);
          }
        }
        //Paso 4. mostrar el contenido de la matriz en consola
        System.out.println("Matriz: ");
        for(int i=0;i<fil;i++){
            System.out.println("------------");
          for(int j=0;j<col;j++){
            System.out.print(m[i][j]+" ");
          }
          System.out.println();
        }
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        System.out.println("La suma de los elementos de la fila 1: ");        
        suma=0; filaNueva=0;
        for(int j=0;j<col;j++){
          suma=suma+m[filaNueva][j];
        }
        System.out.println("la suma es: "+suma);
        
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        for(int j=0;j<col;j++){
          suma=0;
          for(int i=0;i<fil;i++){
             suma=suma+m[i][j];
          }
            v[j]=suma;
        }
        
        //Luego, imprima el vector.
        for(int i=0;i<df;i++){
          System.out.print(v[i]+" ");  
        }
        System.out.println();
        
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".
        num=GeneradorAleatorio.generarInt(12);
        System.out.println("numero a buscar "+num);
        int i=0; 
        while((!encontre)&&(i<fil)){
            int j=0;
            while((!encontre)&&(j<col)){
               if(m[i][j]==num){
                   filaDelNum=i;
                   colDelNum=j;
                   encontre=true;
               } 
               j++;
            }
            i++;
        }
        if(!encontre) System.out.println("no se encontro el elemento");
        else System.out.println("se encuentra en la fila "+filaDelNum+" y la columna "+colDelNum);   
    }
}
//DEBERIA CORTAR LA BUSQUEDA UNA VES QUE ENCUENTRA EL NUMEROEN LA MATRIZ?