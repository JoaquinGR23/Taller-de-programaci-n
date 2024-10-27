package parcial_tj_2024;
/**
 * @author jGimenezruiz
 */
public class TorneoProfesional {
    private String nom, fecha;
    private double montoRecaudadoDeInscripciones, montoPagadoEnPremios;

    public TorneoProfesional(String nom, String fecha, double montoRecaudadoDeInscripciones, double montoPagadoEnPremios) {
        this.nom = nom;
        this.fecha = fecha;
        this.montoRecaudadoDeInscripciones = montoRecaudadoDeInscripciones;
        this.montoPagadoEnPremios = montoPagadoEnPremios;
    }

    private double getMontoRecaudadoDeInscripciones() {
        return montoRecaudadoDeInscripciones;
    }

    private double getMontoPagadoEnPremios() {
        return montoPagadoEnPremios;
    }
    
    public double calculoMonto(){
        return this.getMontoRecaudadoDeInscripciones()-this.getMontoPagadoEnPremios();
    }  
}
