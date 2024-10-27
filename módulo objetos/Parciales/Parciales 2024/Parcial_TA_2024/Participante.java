package parcial_ta_2024;
/**
 * @author jGimenezruiz
 */
public class Participante {
    private String nom, email, contraseña;

    public Participante(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }
    public Participante(String nom, String email, String contraseña) {
        this.nom = nom;
        this.email = email;
        this.contraseña=contraseña;
    }

    private String getNom() {
        return nom;
    }

    private String getEmail() {
        return email;
    }

    public String Contraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        return "nom: " + this.getNom() + ", email: " + this.getEmail();
    }

}
