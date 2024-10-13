package PARCIAL_TC_2023;
/**
 * @author jGimenezruiz
 */
public class Estacion {
    private String dir;
    private Double precio;
    private int df;
    private Surtidor [] sur;

    public Estacion(String dir, Double precio, int v) {
        this.dir = dir;
        this.precio = precio;
        this.df=6;
        this.sur = new Surtidor[this.df]; 
        for(int i=0;i<this.df;i++) sur[i] = new Surtidor(v); 
    }

    public Double getPrecio() { 
        return precio;
    }

    public void cantidadMenorAUnValorIngresado(int x){
        for(int i=0;i<this.df;i++) {
            sur[i].actualizarServicio(x);
        }
    }
    private Venta generarVenta(int dniCli,int cantM3,String medioDePago){
        Venta v= new Venta(dniCli, cantM3, this.getPrecio()*cantM3 , medioDePago);
        return v;
    }
    public void agregarVentaASurtidor(int numSur,int dniCli,int cantM3,String medioDePago){
        Venta ven = generarVenta(dniCli,cantM3,medioDePago); 
        sur[numSur-1].agregarVenta(ven);
    }

    public Venta ventaMax() {
        Venta venMax = null; Venta aux; double max = -1.00;
        for(int i = 0; i < this.df; i++) {
            aux = this.sur[i].calcularMax();
            if(aux.getMonto() > max) {
                max = aux.getMonto(); venMax = aux;
            }
        }
        return venMax;
    }

    public String getDir() {
        return dir;
    }
    
    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.df;i++){
            int k=i+1;
            aux += "Surtidor "+k+" " +sur[i].toString()+" \n";
        }
        return "Estacion de servicio: " + "dir: " + this.getDir() + ", precio: " + this.getPrecio() + " \n"+aux+" ";
    } 
}
