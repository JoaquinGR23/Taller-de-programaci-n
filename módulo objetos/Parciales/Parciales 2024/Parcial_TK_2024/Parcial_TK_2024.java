package parcial_tk_2024;
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TK_2024 {

    public static void main(String[] args) {        
        Lider lider = new Lider(12, 100, "Lider", "Python", 4156345, 150, 10000);
        Empresa em = new Empresa("Empresa X", lider, 6);
        Programador p;
        GeneradorAleatorio.iniciar();
        for(int i=0;i<4;i++){
            p = new Programador(GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarString(4)+2, GeneradorAleatorio.generarInt(34)+4235, GeneradorAleatorio.generarInt(100)+150, 8000);
            em.agregarProgramadorALaEmpresa(p);
        }
        System.out.println("Representacion sin aumento de sueldo: "); //Para probar aumento de sueldo
        System.out.println(em.toString());
        System.out.println("");
        
        em.aumentarSueldoBasico(100);
        
        System.out.println("Representacion con aumento de sueldo: ");//Para probar aumento de sueldo
        System.out.println(em.toString());
        System.out.println("");
        
        System.out.println("Representacion: ");
        System.out.println(em.toString());
        System.out.println("");
    } 
}
