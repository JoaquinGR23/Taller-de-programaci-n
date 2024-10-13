package tema2;
/**
 *
 * @author vsanz
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Ej03QueImprimeB {

    public static void main(String[] args) {
        Persona p1; //Declaro el objeto p1 de clase persona
        Persona p2; //Declaro el objeto p2 de clase persona
        p1 = new Persona(); //Envio un mensaje a la clase persona y me devuelve la referencia objeto p1 
        p1.setNombre("Pablo Sotile"); //Envio un mensaje al objeto p1 y ejecuto el metodo setNombre
        p1.setDNI(11200413); //Envio un mensaje al objeto p1 y ejecuto el metodo setDNI
        p1.setEdad(40); //Envio un mensaje al objeto p1 y ejecuto el metodo setEdad
        p2 = new Persona(); //Envio un mensaje a la clase persona y me devuelve la referencia del objeto p2
        p2.setNombre("Julio Toledo"); //Envio un mensaje al objeto p2 y ejecuto el metodo setNombre
        p2.setDNI(22433516); //Envio un mensaje al objeto p2 y ejecuto el metodo setDNI
        p2.setEdad(51); //Envio un mensaje al objeto p2 y ejecuto el metodo setEdad
        p1 = p2; //Asigno la dir. de memoria de p2 a p1
        p1.setEdad( p1.getEdad() + 1 );//le sumo 1 a la edad 51+1 
        System.out.println(p2.toString()); //Muestro la representacion interna del objeto p2
        System.out.println(p1.toString()); // Muestro la representacion interna del objeto p1
        System.out.println( (p1 == p2) ); //devuelve TRUE, comparo dir. de memorias
        
        GeneradorAleatorio.iniciar(); //Valores generados aleatorios
        Persona p3 = new Persona(GeneradorAleatorio.generarString(4), GeneradorAleatorio.generarInt(250)+41234500, GeneradorAleatorio.generarInt(20)+15);
        System.out.println(p3.toString());
        
        Persona p5 = new Persona(); //VALORES POR TECLADO        
        System.out.println("Ingrese el nombre "); p5.setNombre(Lector.leerString());
        System.out.println("Ingrese el DNI: ");p5.setDNI(Lector.leerInt());
        System.out.println("Ingrese la edad: "); p5.setEdad(Lector.leerInt());
     
        System.out.println(p5.toString());
    
        //EJERCICIO 2
        System.out.println("EJERCICIO 2 ");
        
        //carga del vector 
        int df=15; 
                
        GeneradorAleatorio.iniciar();
        
        Persona [] vectorPer = new Persona[df];
        int  edad, dni=0,dl=0; String nom="";
        System.out.println("ingrese edad:");edad=GeneradorAleatorio.generarInt(13);
        if(edad!=0){
            System.out.println("ingrese el DNI: ");dni=GeneradorAleatorio.generarInt(123);
            System.out.println("ingrese el nombre; "); nom=GeneradorAleatorio.generarString(4);
        } 
        while((dl<df) &&(edad!=0)){
            vectorPer[dl] = new Persona(nom, dni, edad);
            dl++;
            System.out.println("ingrese edad:"); edad=GeneradorAleatorio.generarInt(13);
            if((dl<df) && (edad!=0)){
              System.out.println("ingrese el DNI: ");dni=GeneradorAleatorio.generarInt(123);
              System.out.println("ingrese el nombre; ");nom=GeneradorAleatorio.generarString(4);
            } 
        }              
        //CONTENIDO DEL VECTOR
        for(int i=0;i<dl;i++) System.out.println(vectorPer[i].toString());
        
        int cant=0;
        for (int i=0;i<dl;i++){
            if(vectorPer[i].getEdad()>65) cant++;
        }
        
        //Cantidad de personas mayores a 65 años
        System.out.println("Cantidad de personas mayores a "+65+" años es "+cant);
        
        //Representacion de la persona con menor DNI
        int min=999; String aux="";
        for(int i=0;i<dl;i++){
            if(min>vectorPer[i].getDNI()) {
               min=vectorPer[i].getDNI();  aux=vectorPer[i].toString();
            }    
        }
        System.out.println(aux); 
    
        //EJERCICIO 3
        int fil=5, col=8, dlCol, dlFil;
        Persona [][] m = new Persona[fil][col];
        int [] vecCol = new int[fil];
        
        System.out.println("Ingrese un nombre: "); nom=Lector.leerString();
        if(!(nom.equals("ZZZ"))){
            System.out.println("ingrese el DNI: "); dni=GeneradorAleatorio.generarInt(213);
            System.out.println("Ingrese la edad: "); edad=GeneradorAleatorio.generarInt(30)+20;
        }
        dlFil=0;
        while((dlFil<fil) && (!(nom.equals("ZZZ")))){
          dlCol=0;
          while((dlCol<col) && (!(nom.equals("ZZZ")))){
            m[dlFil][dlCol]= new Persona(nom, dni, edad);
            System.out.println("Ingrese un nombre: "); nom=Lector.leerString();
            if(!(nom.equals("ZZZ"))){
              System.out.println("ingrese el DNI: "); dni=GeneradorAleatorio.generarInt(213);
              System.out.println("Ingrese la edad: "); edad=GeneradorAleatorio.generarInt(30)+20;
            }
            dlCol++;
          }
          vecCol[dlFil]=dlCol; 
          dlFil++;
        }
        //MUESTRA CONTENIDO
        for(int i=0;i<dlFil;i++){
            int k=i+1;
            System.out.println("DIA "+k);
            for(int j=0;j<vecCol[i];j++){
                System.out.print(" |"+m[i][j].toString()+"| ");
            }
            System.out.println("");
        }
        
        for(int i=0;i<dlFil;i++){
            int k=i+1;
            System.out.println("DIA "+k);
            for(int j=0;j<vecCol[i];j++){
                int l=j+1;
                System.out.println("Turno "+l);
                System.out.println("nom: "+m[i][j].getNombre());
            }
        }
    }    
}