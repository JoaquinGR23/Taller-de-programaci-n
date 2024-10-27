package parcial_tj_2024;
/**
 * @author jGimenezruiz
 */
public abstract class Sitio {
    private String nom, dirWeb;
    private int cantUsuReg;

    public Sitio(String nom, String dirWeb) {
        this.nom = nom;
        this.dirWeb = dirWeb;
        this.cantUsuReg = 0;
    }

    private String getNom() {
        return nom;
    }

    private String getDirWeb() {
        return dirWeb;
    }
    
    public int cantUsuReg() { // Donde ingresa esta informacion?
        return cantUsuReg;
    }

    @Override
    public String toString() {
        return "nom: " + this.getNom() + 
                "; localidad: " + this.getDirWeb() + 
                "; cant de usuarios: " + this.cantUsuReg()+
                "; cotizacion comercial del sitio: "+this.cotizarSitio();
    }
    
    public abstract double cotizarSitio();
}
