package parcial_tc_2024;
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TC_2024 {

    public static void main(String[] args) {
        Plataforma p = new Plataforma("plataforma X", 4000, 5); //matriz 5x12
        Estreno es;
        String []v ={"serie","pelicula"}; 
        GeneradorAleatorio.iniciar();
        for(int i=0;i<4;i++){ // creando matriz 4x6
            for(int j=0;j<6;j++){
                es = new Estreno(GeneradorAleatorio.generarString(5)+1, v[GeneradorAleatorio.generarInt(2)], GeneradorAleatorio.generarDouble(4000)+45.32, GeneradorAleatorio.generarInt(50)+1);
                p.agregarEstreno(es, i+1);
            }
        }
        
        System.out.println("Lista de estrenos de la categoria 3");
        System.out.println(p.listaDeEstrenosDeLaCategoriaX(3));
        System.out.println("");
        
        System.out.println("Ganancia total de estrenos del tipo serie");
        System.out.println(p.gananciaTotalEnEstrenoDeSeries());
        System.out.println("");
        
        System.out.println("Representacion: ");
        System.out.println(p.toString());
        System.out.println("");
    }
}
