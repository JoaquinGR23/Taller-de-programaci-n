package tema3;

import PaqueteLectura.*;
/**
 * @author jGimenezruiz
 */
public class mainDelTema3 {
    public static void main(String[] args) {
        
        //EJERCICIO 1 
        Triangulo t = new Triangulo(12, 20, 10, "azul", "rojo");
          
        System.out.println("area"+t.calcularArea()); //Falta recortar decimales.
        System.out.println("perimetro"+t.calcularPerimetro());
        System.out.println("rep:"+t.toString());
        
        
        //EJERCICIO 2 
        System.out.println("");
        System.out.println("EJERCICIO 2: ");
        System.out.println("");
        
        Autor aut = new Autor("nombre del autor", "bio del autor", "origen del autor");
        Libro li = new Libro("titulo del libro", "editorial del libro ", aut, "isb del libro");
        Libro li2 = new Libro("titulo libro 2", "editorial libro 2", 2024, aut, "isbn del libro 2", 100.32);
        
        System.out.println("AUTOR: "+li.getPrimerAutor().toString());
        System.out.println("LIBRO: "+li.toString());
        System.out.println("AUTOR: "+li2.getPrimerAutor().toString());
        System.out.println("LIBRO 2: "+li2.toString());
            
        //EJERCICIO 3 
        System.out.println("");
        System.out.println("EJERCICIO 3: ");
        System.out.println("");
                         //INICISO B
        Autor au1 = new Autor("nom au1", "bio au1", "origen au1");
        Autor au2 = new Autor("nom au2", "bio au2", "origen au2");
        Autor au3 = new Autor("nom au3", "bio au3", "origen au3");
        Libro liEst1 = new Libro("nom 1", "edi 1", au1, "isbn 1");
        Libro liEst2 = new Libro("Mujercitas", "edi 2", au2, "isbn 2");
        Libro liEst3 = new Libro("nom 3", "edi 3", au3, "isbn 3");
        Estante est = new Estante();
        
        System.out.println("dim Logica: "+est.cantidadLibrosAlmacenados());
        System.out.println("lugar: "+est.isHayEspacio());
        est.agregarLibro(liEst1);
        est.agregarLibro(liEst2);
        est.agregarLibro(liEst3);
        
        System.out.println("dim Logica: "+est.cantidadLibrosAlmacenados());
        System.out.println("lugar: "+est.isHayEspacio());
        
        
        //Busqueda en el vector:
        Libro libroObtenido = est.getLibroConNomParticular("Mujercita"); //traigo el libro 
        if(libroObtenido != null) System.out.println("nom del autor de libro Mujercitas: "+libroObtenido.getPrimerAutor().getNom());
        else System.out.println("no se encontro el libro");
        
        
                                //INCISO C
        System.out.println("ingrese un num: ");
        Estante est2 = new Estante(Lector.leerInt());            
    
    
        //EJERCICIO 4
        System.out.println("");
        System.out.println("EJERCICIO 4: ");
        System.out.println("");
        
        GeneradorAleatorio.iniciar();
        Cliente cli; 
        int num=10;
        Hotel h= new Hotel(num);
        for(int i=0;i<10;i++){ 
            cli = new Cliente(GeneradorAleatorio.generarString(5),GeneradorAleatorio.generarInt(10) , GeneradorAleatorio.generarInt(123));
            h.agregarCliente(cli, i+1);
        }
        
        System.out.println(h.toString());
        h.aumentarMonto(GeneradorAleatorio.generarDouble(500));
        System.out.println("");
        System.out.println("habitaciones con nuevo costo: ");
        System.out.println(h.toString());
        
    }
}
