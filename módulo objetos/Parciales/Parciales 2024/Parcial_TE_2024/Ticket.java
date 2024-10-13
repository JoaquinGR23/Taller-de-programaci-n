package parcial_te_2024;
/**
 * @author jGimenezruiz
 */
public class Ticket {
    private int numTicket, cuit, cantProdComprados;
    private double monto;
    private String medioDePago;

    public Ticket(int numTicket, int cuit, int cantProdComprados, double monto, String medioDePago) {
        this.numTicket = numTicket;
        this.cuit = cuit;
        this.cantProdComprados = cantProdComprados;
        this.monto = monto;
        this.medioDePago = medioDePago;
    }

    private int getNumTicket() {
        return numTicket;
    }

    private int getCuit() {
        return cuit;
    }

    private int getCantProdComprados() {
        return cantProdComprados;
    }

    private double getMonto() {
        return monto;
    }

    private String getMedioDePago() {
        return medioDePago;
    }
    public boolean pagoConCredito(){
        return this.getMedioDePago().equals("credito");
    }
    @Override
    public String toString() {
        return this.getNumTicket() + ", " + 
                this.getCuit() + ", " + 
                this.getCantProdComprados() + ", " + 
                this.getMonto() + ", " + 
                this.getMedioDePago();
    }
}
