package parcial_turnokl_2024;
/**
 * @author jGimenezruiz
 */
public class Carrera {
    private String nomCarrera, facuALaQuePertenece;
    private int anioDeCreacion;

    public Carrera(String nomCarrera, String facuALaQuePertenece, int anioDeCreacion) {
        this.nomCarrera = nomCarrera;
        this.facuALaQuePertenece = facuALaQuePertenece;
        this.anioDeCreacion = anioDeCreacion;
    }
    
    
    private String getNomCarrera() {
        return nomCarrera;
    }

    private String getFacuALaQuePertenece() {
        return facuALaQuePertenece;
    }

    public int anioDeCreacion() {
        return anioDeCreacion;
    }

    @Override
    public String toString() {
        return this.getNomCarrera() + ". " + this.getFacuALaQuePertenece() + ". Año de creación: " + this.anioDeCreacion();
    }  
}
