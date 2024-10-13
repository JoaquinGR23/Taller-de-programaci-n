package parcial_t1_redictado2024;
/**
 * @author jGimenezruiz
 */
public class Curso {
    private String descripcion;
    private Turno online, presencial;

    public Curso(String descripcion, Turno online, Turno presencial) {
        this.descripcion = descripcion;
        this.online = online;
        this.presencial = presencial;
    }

    private String getDescripcion() {
        return descripcion;
    }
    
    private boolean residenciaLaPlata(Alumno al){
        return al.residencia().equals("La Plata");
    }
    public void agregarAlumnoAlCurso(Alumno al){
        if(this.residenciaLaPlata(al)) this.presencial.agregarAlumno(al);
        else this.online.agregarAlumno(al);
    }
    private double gananciaMensualNeta(){
        return this.presencial.recaudacion()+this.online.recaudacion();
    }
    public boolean esRentable(){
        return this.gananciaMensualNeta()>800000;
    }

    @Override
    public String toString() {
        String aux="Turno Online: {"+this.online.toString()+"} \n";
        aux +="Turno Presencial: {"+this.presencial.toString()+"} \n";
        
        return this.getDescripcion()+", "+this.gananciaMensualNeta()+", \n"+aux;
    }
}
