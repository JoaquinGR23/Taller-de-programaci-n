package PARCIAL_TC_2023;
/**
 * @author jGimenezruiz
 */
public class Venta {
    private int dniCli,cantCargada;
    private double monto;
    private String medioDePago;

    public Venta(int dniCli, int cantCargada, double monto, String medioDePago) {
        this.dniCli = dniCli;
        this.cantCargada = cantCargada;
        this.monto = monto;
        this.medioDePago=medioDePago;
    }

    public int getDniCli() {
        return dniCli;
    }

    public int getCantCargada() {
        return cantCargada;
    }
    
    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "dniCli: " + this.getDniCli() + 
                ", cantCargada: " + this.getCantCargada() + 
                ", monto:" + this.getMonto();
    }  
}
