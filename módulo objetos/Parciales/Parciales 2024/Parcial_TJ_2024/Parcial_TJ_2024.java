package parcial_tj_2024;
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TJ_2024 {

    public static void main(String[] args) {
        SitioTorneoAmateur a = new SitioTorneoAmateur("sitio X", "dir Web");
        SitioTorneoProfesional p = new SitioTorneoProfesional(10, "sitio X", "dir Web");
        TorneoProfesional t;
        
        GeneradorAleatorio.iniciar();
        for(int i=0;i<5;i++){
            t = new TorneoProfesional(GeneradorAleatorio.generarString(5)+1, GeneradorAleatorio.generarString(7)+1, GeneradorAleatorio.generarDouble(60)+300,GeneradorAleatorio.generarDouble(60)+500);
            System.out.println(p.registrarTorneoProfesional(t));
            
            a.registrarTorneoAmateur(i + GeneradorAleatorio.generarInt(30));
        }
        
        System.out.println("rep del torneo amateur: ");
        System.out.println(a.toString());
        System.out.println("");
        
        System.out.println("rep del torneo profesional: ");
        System.out.println(p.toString());
        System.out.println("");
        
    }
}
