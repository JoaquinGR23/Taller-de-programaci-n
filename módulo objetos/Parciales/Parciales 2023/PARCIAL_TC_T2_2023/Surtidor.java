package PARCIAL_TC_2023;
/**
 * @author jGimenezruiz
 */
public class Surtidor {
    private boolean fueraDeServicio;
    private Venta []v;
    private int dl,df;
    Venta ventaMax;
 

    public Surtidor( int V) {
        this.fueraDeServicio = false;
        this.df=V;
        this.v = new Venta[this.df]; 
        this.dl=0;
    }

    public boolean isFueraDeServicio() {
        return fueraDeServicio;
    }

    private void setFueraDeServicio(boolean fueraDeServicio) { 
        this.fueraDeServicio = fueraDeServicio;
    }
    public void agregarVenta(Venta v){
        if(dl<df) {
           this.v[dl]=v; dl++;
        }
    }
     public Venta calcularMax() {
        double max = -1.00; Venta venMax = null;
        for(int i=0; i < this.dl; i++) {
            if(this.v[i].getMonto() > max) {
                max = this.v[i].getMonto();
                venMax = this.v[i];
            }
        }
        return venMax;
    }
    private int sumaCantidad(){
        int suma=0;
        for(int i=0;i<this.dl;i++) suma += v[i].getCantCargada();
        return suma;
    }
    public void actualizarServicio(int x){
        if(sumaCantidad()<x) this.setFueraDeServicio(true);
    }
    @Override
    public String toString() {
        String aux ="";
        for(int i=0;i<this.dl;i++){
            aux += "Ventas: "+ v[i].toString()+"; ";
        }
        return  "fueraDeServicio: " + this.isFueraDeServicio()+ " "+ aux;
    }   
}
