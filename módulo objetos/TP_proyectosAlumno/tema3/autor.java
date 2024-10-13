package tema3;
/**
 * @author joaqu
 */
public class autor {
    private String nom,bio,origen;

    public autor(String nom, String bio, String origen) {
        this.nom = nom;
        this.bio = bio;
        this.origen = origen;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString() {
        return "nom: " + nom + ", bio: " + bio + ", origen: " + origen ;
    }
    
    
}
