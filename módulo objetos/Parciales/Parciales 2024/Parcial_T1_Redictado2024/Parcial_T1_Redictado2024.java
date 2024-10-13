package parcial_t1_redictado2024;
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_T1_Redictado2024 {

    public static void main(String[] args) {
        Turno online = new Turno(100);
        Turno presencial = new Turno(100);
        Curso c = new Curso("descripcion curso", online, presencial);
        Alumno al;
        String [] v={"La Plata","Chacarita","Los Hornos","Berisso","Villa elvira","Pueblo Lejano"};
        GeneradorAleatorio.iniciar();
        for(int i=0;i<10;i++){
            al = new Alumno(GeneradorAleatorio.generarString(4)+1, v[GeneradorAleatorio.generarInt(5)], GeneradorAleatorio.generarInt(432)+1232);
            c.agregarAlumnoAlCurso(al);
        }
        online.CostoCuota(10);  online.NomDocente("docente online"); online.SueldoDocente(1);
        presencial.CostoCuota(100); presencial.NomDocente("docente presencial"); presencial.SueldoDocente(1); 
        System.out.println("Representacion: ");
        System.out.println(c.toString()+"Es rentable: "+c.esRentable());
        System.out.println("");  
    } 
}
