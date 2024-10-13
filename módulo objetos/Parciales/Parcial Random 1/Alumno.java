package parcial.random.pkg1;
/**
 * @author jGimenezruiz
 */
public class Alumno {
    private int edad;
    private double puntaje;
    private String nom,instrumento;

    public Alumno(int edad, String nom, String instrumento) {
        this.edad = edad;
        this.puntaje = -1;
        this.nom = nom;
        this.instrumento = instrumento;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    
    public String getNom() {
        return nom;
    }
}
