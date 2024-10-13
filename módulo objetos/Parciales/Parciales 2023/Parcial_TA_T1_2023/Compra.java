package parcial_ta_t1_2023;
/**
 * @author jGimenezruiz
 */
public class Compra {
   private int numCompra,df,dl;
    private Producto [] p;
    private Fecha f;

    public Compra(int numCompra, int N, Fecha f) {
        this.numCompra = numCompra;
        this.df = N;
        this.f = f;
        this.dl=0;
        this.p=new Producto[this.df];
    }
    
    private int getNumCompra() {
        return numCompra;
    }
    
    public double precioFinalDeLaCompra(){
        double monto=0.0;
        for(int i=0;i<this.dl;i++){
            monto += this.p[i].precioFinal();
        }
        return monto;
    }
    public void agregarProductos(Producto p){
        if(this.dl<this.df){
            this.p[dl]= p; this.dl++;
        } 
    } 
    public String obtenerResumenDeLaCompra(){
        String aux ="num de compra: "+this.getNumCompra()+" - "+f.toString()+"\n";
        for(int i=0;i<this.dl;i++){
            aux += this.p[i].toString()+"\n";
        }
        aux += "precio final de la compra: "+this.precioFinalDeLaCompra();
        return aux;
    }
    public boolean saberSiEsAbonableEnCuotas(){
        if(this.precioFinalDeLaCompra()>100000) return true;
        else return false;
    }
}
