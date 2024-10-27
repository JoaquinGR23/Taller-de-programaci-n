package parcial_tn_2024;
/**
 * @author jGimenezruiz
 */
public abstract class Persona {
    private String ape,nom;
    private int dni,cel;

    public Persona(String ape, String nom, int dni, int cel) {
        this.ape = ape;
        this.nom = nom;
        this.dni = dni;
        this.cel = cel;
    }

    private String getApe() {
        return ape;
    }

    private String getNom() {
        return nom;
    }

    private int getDni() {
        return dni;
    }

    private int getCel() {
        return cel;
    }

    @Override
    public String toString() {
        return " DNI: " + this.getDni() +" - "+ this.getApe()+" "+this.getNom()+ " - Te: " + this.getCel();
    } 
}
