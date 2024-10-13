package tema3;

import PaqueteLectura.*;

/**
 * @author joaqu
 */
public class mainDelTema3 {
    public static void main(String[] args) {
        
        //EJERCICIO 1 
        triangulo t = new triangulo(12, 20, 10, "azul", "rojo");
          
        System.out.println("area"+t.calcularArea()); //Falta recortar decimales.
        System.out.println("perimetro"+t.calcularPerimetro());
        System.out.println("rep:"+t.toString());
        
        
        //EJERCICIO 2 (PREGUNTAR CUAL DE LAS DOS FORMAS ES LA CORRECTA)
        System.out.println("");
        System.out.println("EJERCICIO 2: ");
        System.out.println("");
        
        autor aut = new autor("nombre del autor", "bio del autor", "origen del autor");
        Libro li = new Libro("titulo del libro", "editorial del libro ", aut, "isb del libro");
        Libro li2 = new Libro("titulo libro 2", "editorial libro 2", 2024, aut, "isbn del libro 2", 100.32);
        
        System.out.println("AUTOR: "+li.getPrimerAutor().toString());
        System.out.println("LIBRO: "+li.toString());
        System.out.println("AUTOR: "+li2.getPrimerAutor().toString());
        System.out.println("LIBRO 2: "+li2.toString());
        
        System.out.println("OTRA FORMA: ");
        
        
        //OTRA FORMA:
        autor au = new autor("Autor x", "bio x", "origen x");
        
        Libro li3 = new Libro("nom libro3", "editorial 3", au, "isb 3");
        
        System.out.println(li3.getToStringDelAutor());
        System.out.println(li3.toString());
        System.out.println(li3.getNombreDelAutor()+" "+ li3.getBiografiaDelAutor()+" "+li3.getOrigenDelAutor());     
        li3.setNombreDelAutor("pepe");
        System.out.println(li3.getToStringDelAutor());
        
        //EJERCICIO 3 
        System.out.println("");
        System.out.println("EJERCICIO 3: ");
        System.out.println("");
                         //INICISO B
        autor au1 = new autor("nom au1", "bio au1", "origen au1");
        autor au2 = new autor("nom au2", "bio au2", "origen au2");
        autor au3 = new autor("nom au3", "bio au3", "origen au3");
        Libro liEst1 = new Libro("nom 1", "edi 1", au1, "isbn 1");
        Libro liEst2 = new Libro("Mujercitas", "edi 2", au2, "isbn 2");
        Libro liEst3 = new Libro("nom 3", "edi 3", au3, "isbn 3");
        Estante est = new Estante();
        
        System.out.println("dim Logica: "+est.getDl());
        System.out.println("lugar: "+est.isHayEspacio());
        est.setAgregarLibro(liEst1);
        est.setAgregarLibro(liEst2);
        est.setAgregarLibro(liEst3);
        
        System.out.println("dim Logica: "+est.getDl());
        System.out.println("lugar: "+est.isHayEspacio());
        
        
        //Busqueda en el vector:
        Libro libroObtenido = est.getLibroConNomParticular("Mujercita"); //traigo el libro 
        if(libroObtenido != null) System.out.println("nom del autor de libro Mujercitas: "+libroObtenido.getNombreDelAutor());
        else System.out.println(libroObtenido);
                                //INCISO C
        System.out.println("ingrese un num: ");
        Estante est2 = new Estante(Lector.leerInt());            
    
    
        //EJERCICIO 4
        System.out.println("");
        System.out.println("EJERCICIO 4: ");
        System.out.println("");
        
        GeneradorAleatorio.iniciar();
        cliente cli; 
        int num=10;
        hotel h= new hotel(num);
        for(int i=0;i<10;i++){ //Se puede usar una estructura para cargar datos?
            cli = new cliente(GeneradorAleatorio.generarString(5),GeneradorAleatorio.generarInt(10) , GeneradorAleatorio.generarInt(123));
            h.agregarCliente(cli, i+1);
        }
        
        System.out.println(h.toString());
        h.aumentarMonto(GeneradorAleatorio.generarDouble(500));
        System.out.println("");
        System.out.println("habitaciones con nuevo costo: ");
        System.out.println(h.toString());
        
    }
}
