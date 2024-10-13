package parcial_tf_2024;
/**
 * @author jGimenezruiz
 */
public class Ticket {
    private int numTicket, dniCli, cantLibrosComprados;
    private double monto;
    private String medioDePago;

    public Ticket(int numTicket, int dniCli, int cantLibrosComprados, double monto, String medioDePago) {
        this.numTicket = numTicket;
        this.dniCli = dniCli;
        this.cantLibrosComprados = cantLibrosComprados;
        this.monto = monto;
        this.medioDePago = medioDePago;
    }

    private int getNumTicket() {
        return numTicket;
    }

    private int getDniCli() {
        return dniCli;
    }

    public int cantLibrosComprados() {
        return cantLibrosComprados;
    }

    public double montoAbonado() {
        return monto;
    }

    private String getMedioDePago() {
        return medioDePago;
    }

    @Override
    public String toString() {
        return + this.getNumTicket() + ", " + 
                this.getDniCli() + ", " + 
                this.cantLibrosComprados() + ", " + 
                this.montoAbonado() + ", " + 
                this.getMedioDePago();
    }
}
