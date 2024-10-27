package parcial_tn_2024;
/**
 * @author jGimenezruiz
 */
public class Paciente extends Persona{
    private String obraSocial;

    public Paciente(String obraSocial, String ape, String nom, int dni, int cel) {
        super(ape, nom, dni, cel);
        this.obraSocial = obraSocial;
    }

    private String getObraSocial() {
        return obraSocial;
    }
    
    
    public boolean esObraSocialIngresada(String X){
        return this.getObraSocial().equals(X);
    }

    @Override
    public String toString() {
        return super.toString() + ". OS: " + this.getObraSocial();
    }  
}
