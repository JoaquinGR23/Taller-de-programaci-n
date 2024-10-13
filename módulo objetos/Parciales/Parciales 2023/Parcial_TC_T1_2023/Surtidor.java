package parcial_tc_t1_2023;
/**s
 * @author jGimenezruiz
 */
public class Surtidor {
     private String combustible;
    private double precio;
    private int df,dl;
    private Venta []v;

    public Surtidor(String combustible, double precio, int V) {
        this.combustible = combustible;
        this.precio = precio;
        this.df = V;
        this.dl = 0;
        this.v= new Venta[this.df];
    }

    private String getCombustible() {
        return combustible;
    }

    private double getPrecio() {
        return precio;
    }
    private void agregarVenta(Venta ven){
        if(this.dl<this.df) {
            this.v[dl]=ven; this.dl++;
        }
    }
    public void generarVenta(int dni,int cant,String medioDePago){
        Venta ven = new Venta(dni, cant, this.getPrecio()*cant, medioDePago);
        this.agregarVenta(ven);
    }
    public double calcularMontoSusVentas(){
        double monto=0;
        for(int i=0;i<this.dl;i++){
           if(v[i].pagoConEfectivo()) monto += this.v[i].getMonto();
        }
        return monto;
    }

    @Override
    public String toString() {
        String aux="Ventas: {";
        for(int i=0;i<this.dl;i++){
            aux += this.v[i].toString()+"; ";
        }
        aux +="}";
        return  this.getCombustible() + ", " + this.getPrecio() +"; "+ aux;
    }
    
}
