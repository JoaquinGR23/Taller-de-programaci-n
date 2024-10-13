package tema4;
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class MainTema4 {

    public static void main(String[] args) {
        //EJERCICIO 1
        System.out.println("");
        System.out.println("EJERCICIO 1: ");
        System.out.println("");
        Triangulo t;
        GeneradorAleatorio.iniciar();
        for(int i=0;i<4;i++){
            t = new Triangulo(GeneradorAleatorio.generarDouble(14),GeneradorAleatorio.generarDouble(14), GeneradorAleatorio.generarDouble(14), GeneradorAleatorio.generarDouble(14),1+ GeneradorAleatorio.generarString(14),1+ GeneradorAleatorio.generarString(14));
            System.out.println(t.toString());
            t.despintar();
            System.out.println(t.toString());
        }
    
        //EJERCICIO 2
        System.out.println("");
        System.out.println("EJERCICIO 2: ");
        System.out.println("");
        
        Entrenadores ent;
        Jugadores jug;
        for(int i=0;i<3;i++){
            ent= new Entrenadores(GeneradorAleatorio.generarInt(10)+1, GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarDouble(40000), GeneradorAleatorio.generarInt(6)+1);
            jug = new Jugadores(GeneradorAleatorio.generarInt(5)+1, GeneradorAleatorio.generarInt(10)+1, GeneradorAleatorio.generarString(4)+1, GeneradorAleatorio.generarDouble(40000), GeneradorAleatorio.generarInt(6)+1);
            
            System.out.println(ent.toString());
            System.out.println(jug.toString());
        }
        
         //EJERCICIO 5
        System.out.println("");
        System.out.println("EJERCICIO 5: ");
        System.out.println("");
        
        Dibujo d = new Dibujo("un dibujo");
        Cuadrado c1 = new Cuadrado(10,"Violeta","Rosa");
        Rectangulo r= new Rectangulo(20,10,"Azul","Celeste");
        Cuadrado c2= new Cuadrado(30,"Rojo","Naranja");
        d.agregar (c1);
        d.agregar (r);
        d.agregar (c2);
        d.mostrar();
    }
}
