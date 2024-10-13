package parcial_tc_t1_2023;
/**
 * @author jGimenezruiz
 */
public class Estacion {
    private String dirEstacion;
    private int df,dl;
    private Surtidor [] sur;

    public Estacion(String dirEstacion) {
        this.dirEstacion = dirEstacion;
        this.df = 6;
        this.dl=0;
        this.sur = new Surtidor[this.df];
    }

    private int cantidadDeSurtidores() {
        return dl;
    }

    private String getDirEstacion() {
        return dirEstacion;
    }
    
    
    public void agregarSurtidor(Surtidor sur){
        if(this.dl<this.df){
            this.sur[dl]=sur; this.dl++;
        }
    }
    public void agregarVentaAlSurtidor(int N,int dni,int cant,String medioDePago){
        sur[N-1].generarVenta(dni,cant,medioDePago);
    }
    public int surtidorConMayorMontoEntreSusVentas(){
        int surMax=-1; double monto,max=-1;
        for(int i=0;i<this.dl;i++){
            monto= sur[i].calcularMontoSusVentas();
            if(monto>max) {
                max= monto; surMax=i+1;
            }
        }
        return surMax;
    }

    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.dl;i++){
            aux +="Surtidor "+(i+1)+"; "+sur[i].toString()+"\n";
        }
        return "Estacion de servicio: " + this.getDirEstacion()+"; "+this.cantidadDeSurtidores()+"\n"+aux;
    }   
}
