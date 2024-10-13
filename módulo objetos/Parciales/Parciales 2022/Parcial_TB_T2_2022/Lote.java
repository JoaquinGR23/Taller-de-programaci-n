package parcial_tb_t2_2022;
/**
 * @author jGimenezruiz
 */
public class Lote {
    private double precio;
    private Comprador com;

    public Lote() {
        this.precio = 50000;
        this.com = null;
    }
    public void agregarComprador(Comprador c){
        this.com =c;
    }

    public double getPrecio() {
        return precio;
    }
    private void incrementarPrecioDelLote(double nuevoPrecio){
        this.precio=nuevoPrecio;
    }
    public void calculo(double porc){
        double incremento = (double)porc/100*this.precio;
        if(this.com==null) this.incrementarPrecioDelLote(incremento+this.getPrecio());
    }
    public boolean hayComprador(){
        return this.com!=null;
    }
    @Override
    public String toString() {
        String aux="-" + this.getPrecio() +"-";
        if(this.com!=null) aux +=this.com.toString();
        else aux +="Disponible para la venta";
        return aux;
    }
}
