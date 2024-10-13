package parcial_t1_redictado2024;
/**
 * @author jGimenezruiz
 */
public class Alumno {
    private String nom, lugar;
    private int dni;

    public Alumno(String nom, String lugar, int dni) {
        this.nom = nom;
        this.lugar = lugar;
        this.dni = dni;
    }

    private String getNom() {
        return nom;
    }

    public String residencia() {
        return lugar;
    }

    private int getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return  this.getDni() + ", " +this.getNom() + ", " + this.residencia();
    }  
}
