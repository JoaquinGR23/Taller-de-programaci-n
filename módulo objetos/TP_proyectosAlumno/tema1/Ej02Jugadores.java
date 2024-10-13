
package tema1;

//Paso 1: Importar la funcionalidad para lectura de datos

import PaqueteLectura.Lector;
public class Ej02Jugadores {
    public static void main(String[] args) {
        //Paso 4: Declarar indice y variables auxiliares a usar
        int df = 4, i,cant;
        double suma, num;
        //Paso 2: Declarar la variable vector de double 
        double []v= new double[df];  
        //Paso 3: Crear el vector para 15 double 
        suma=0;
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        for(i=0;i<df;i++){
          System.out.println("ingrese la altura: ");
          num=Lector.leerDouble();
          System.out.println("posicion del vector: "+i);
          v[i]=num;
          suma=suma+num;
        }
        double prom=(double)suma/df;
        //Paso 7: Calcular el promedio de alturas, informarlo
        System.out.println("promedio de las alturas es: "+prom);
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        cant=0;
        for(i=0;i<df;i++){
         if(v[i]>prom) cant++;
        }
        //Paso 9: Informar la cantidad.
        System.out.println("la cantidad de alturas que superan el promedio es "+cant);
    }
    
}
