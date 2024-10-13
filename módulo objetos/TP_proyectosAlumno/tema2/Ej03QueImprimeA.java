
package tema2;

/**
 *
 * @author vsanz
 */
public class Ej03QueImprimeA {
    public static void main(String[] args) {
        String saludo1=new String("hola"); //instancia 1==>se envia mensaje de creacion a la clase STRING y devuelve la referencia objeto saludo1
        String saludo2=new String("hola");//instancia 2==>se envia mensaje de creacion a la clase STRING y devuelve la referencia objeto saludo2
        System.out.println(saludo1 == saludo2); // false, compara 2 referencias de memorias
        System.out.println(saludo1 != saludo2); //true, compara 2 referencias de memorias
        System.out.println(saludo1.equals(saludo2)); //true, compara el contenido del objeto saludo1 con el contenido del objeto saludo2
    } 
}
