package parcial_tc_t1_2023;
/**
 * @author jGimenezruiz
 */
public class Venta {
    private int dni,cant;
    private double monto;
    private String medioDePago;

    public Venta(int dni, int cant, double monto, String medioDePago) {
        this.dni = dni;
        this.cant = cant;
        this.monto = monto;
        this.medioDePago = medioDePago;
    }

    private int getDni() {
        return dni;
    }

    private int getCant() {
        return cant;
    }

    public double getMonto() {
        return monto;
    }

    private String getMedioDePago() {
        return medioDePago;
    }
    public boolean pagoConEfectivo(){
        return this.getMedioDePago().equals("efectivo");
    }

    @Override
    public String toString() {
        return  this.getDni() + ", " + this.getCant() + ", " + this.getMonto();
    }  
}