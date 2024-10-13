package parcial_tb_t1_2023;
/**
 * @author jGimenezruiz
 */
public class Alumno {
    private String ape,nom;
    private int legajo;
    private double nota;

    public Alumno(String ape, String nom, int legajo) {
        this.ape = ape;
        this.nom = nom;
        this.legajo = legajo;
        this.nota = 0;
    }

    public String getApe() {
        return ape;
    }

    public String getNom() {
        return nom;
    }

    public int getLegajo() {
        return legajo;
    }

    public double getNota() {
        return nota;
    }
    public void asignarNota(double nota){
        this.nota= nota;
    }
    @Override
    public String toString() {
        String aux=this.getLegajo() + " " + this.getApe() + ", " + this.getNom() +" ";
        if(this.getNota()>0) aux += this.getNota();
        return  aux;
    }
}