package tema3;
/**
 * @author jGimenezruiz
 */
public class Autor {
    private String nom,bio,origen;

    public Autor(String nom, String bio, String origen) {
        this.nom = nom;
        this.bio = bio;
        this.origen = origen;
    }

    public String getNom() {
        return nom;
    }
    
    @Override
    public String toString() {
        return "nom: " + this.nom + ", bio: " + this.bio + ", origen: " + this.origen ;
    }
}
