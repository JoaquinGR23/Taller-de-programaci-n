package parcial_turnokl_2024;
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TurnoKL_2024 {

    public static void main(String[] args) {
        Carrera car = new Carrera("Licenciatura en Sistema Plan 2015", "UNLP-Informatica", 2004); //2004-2007
        PorAnioAcademico acad = new PorAnioAcademico(car, 4); //matriz 4x4
        
        car = new Carrera("Ingeniería en Computación Plan 2015", "UNLP-Exactas", 2005);//2005-2009
        PorTrimestre tri = new PorTrimestre(car, 5); //matriz 5x4
        
        GeneradorAleatorio.iniciar(); 
        for(int i=0;i<3;i++){ //Carga para el anio academico una matriz 3x3
          for(int j=0;j<3;j++){
              acad.registrarCantDeEgresados(GeneradorAleatorio.generarInt(20), 2004+i, j+1);
          }   
        }
        
        for(int i=0;i<4;i++){ //Carga para el trimestre una matriz 4x3
          for(int j=0;j<3;j++){
              tri.registrarCantDeEgresados(GeneradorAleatorio.generarInt(20), 2005+i, j+1);
          }   
        }
        
        //para anio academico:
        System.out.println("Representacion: ");
        System.out.println(acad.toString());
        System.out.println("");
   
        //para trimestre:
        System.out.println("Cantidad de trimestres que tienen exactamente 22 egresados: ");
        System.out.println(tri.obtenerLaCantidadDeTrimestresQueRegistranXEgresados(22));
        System.out.println("");
        System.out.println("Representacion:");
        System.out.println(tri.toString());
        System.out.println("");         
    }  
}
