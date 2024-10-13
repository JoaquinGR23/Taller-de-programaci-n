package parcial_tb_t2_2022;
/**
 * @author jGimenezruiz
 */
public class Comprador {
    private String nom,ape,ciudad;
    private int dni;

    public Comprador(String nom, String ape, String ciudad, int dni) {
        this.nom = nom;
        this.ape = ape;
        this.ciudad = ciudad;
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public String getApe() {
        return ape;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return " Comprador: {"+this.getDni()+"-"+this.getApe()+" "+this.getNom()+"-"+this.getCiudad() +"}";
    }

}
