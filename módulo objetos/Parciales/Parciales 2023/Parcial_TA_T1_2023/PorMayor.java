package parcial_ta_t1_2023;
/**
 * @author jGimenezruiz
 */
public class PorMayor extends Compra {
    private ConsumidorFinal c;

    public PorMayor(ConsumidorFinal c, int numCompra, int N, Fecha f) {
        super(numCompra, N, f);
        this.c = c;
    }
    @Override
    public void agregarProductos(Producto p){
        if(p.getCantProd()>6) super.agregarProductos(p);
    }

    public double precioPrueba(){
        return super.precioFinalDeLaCompra();
    }
    @Override
    public double precioFinalDeLaCompra(){
        return ((1-0.21)*super.precioFinalDeLaCompra());
    }
}
