package tema2;
/*
 * @author jGimenezRuiz
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class ejercicio5 {
    public static void main(String[] args) {
        int df=20,golL=0, golV=0, dl=0; 
        String nomV, nomL="";
        Partido[] vectorP = new Partido[df];
        GeneradorAleatorio.iniciar();
        
        System.out.println("ingrese el nombre del equipo visitante");
        nomV = Lector.leerString();
        if(!(nomV.equals("ZZZ"))){
            System.out.println("ingrese el nombre del equipo local: "); nomL = Lector.leerString();
            System.out.println("ingrese los goles del equipo local: "); golL = GeneradorAleatorio.generarInt(5);
            System.out.println("ingrse los goles del equipo visitante: "); golV = GeneradorAleatorio.generarInt(5);
        }
        while((dl<df)&& (!(nomV.equals("ZZZ")))){
            vectorP[dl] = new Partido(nomL, nomV, golL, golV);
            dl++;
            System.out.println("ingrese el nombre del equipo visitante");
            nomV = Lector.leerString();
            if((dl<df)&& (!(nomV.equals("ZZZ")))){
              System.out.println("ingrese el nombre del equipo local: "); nomL = Lector.leerString();
              System.out.println("ingrese los goles del equipo local: "); golL = GeneradorAleatorio.generarInt(5);
              System.out.println("ingrse los goles del equipo visitante: "); golV = GeneradorAleatorio.generarInt(5);
            }            
        }
        System.out.println("contenido del vector: ");
        for(int i=0;i<dl;i++){
            int k=i+1;
            System.out.println("partido "+k);
        }
        
        System.out.println("Representacion de los partidos: ");
        
        int cant=0, total=0;
        for(int i=0;i<dl;i++){
            int k=i+1; System.out.println("PARTIDO "+k);
            System.out.println(vectorP[i].getLocal()+"["+vectorP[i].getGolesLocal()+"]"+" VS "+vectorP[i].getVisitante()+"["+vectorP[i].getGolesVisitante()+"]");
            
            if(vectorP[i].getGanador().equals("river")) cant++;
            
            if(vectorP[i].getLocal().equals("boca")) total=total+vectorP[i].getGolesLocal();
            
            
        }
        System.out.println("cantidad de partidos que gano river es:"+cant);
        System.out.println("cantidad de goles que hizo boca jugando de local es:"+total);
    } 
}
