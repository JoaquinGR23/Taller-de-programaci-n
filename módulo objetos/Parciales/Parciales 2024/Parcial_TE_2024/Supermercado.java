package parcial_te_2024;
/**
 * @author jGimenezruiz
 */
public class Supermercado {
    private String dirSupermercado;
    private int numVentaActual,df,dl;
    private Caja [] c;

    public Supermercado(String dirSupermercado) {
        this.dirSupermercado = dirSupermercado;
        this.df = 5;
        this.dl=0;
        this.numVentaActual=0;
        this.c=new Caja[this.df];
    }
    public void agregarCaja(Caja c){
        if(this.dl<this.df){
            this.c[dl]=c; this.dl++;
        }
    }

    private int cantidadDeCajas() {
        return dl;
    }

    private String getDirSupermercado() {
        return dirSupermercado;
    }
    
    
    private int getNumVenta() {
        return numVentaActual;
    }

    private void setNumVenta(int numVenta) {
        this.numVentaActual = numVenta;
    }
    private Ticket generarTicket(int numTicket,int cuit, int cantProd, double monto,String medio){
        return new Ticket(numTicket, cuit, cantProd, monto, medio);
    }
    
    public void agregarTicketDeCompra(int N, int cuit, int cantProd,double monto, String medio){
        Ticket t= this.generarTicket(this.getNumVenta(),cuit,  cantProd, monto,  medio);
        this.c[N-1].agregarTicket(t);
        this.setNumVenta(this.getNumVenta()+1);
    }
    
    public int numCajaConMenorCantidadDeTicket(){
        int cant,numCaja=0,min=9999; 
        for(int i=0;i<this.dl;i++){
            cant=this.c[i].ticketsEmitidos();
            if(cant < min) {
                min = cant; numCaja=i+1;
            }
        }
        return numCaja;
    }

    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.dl;i++){
            aux += "Caja "+(i+1)+": "+this.c[i].toString()+"\n";
        }
        return "Supermercado: " + this.getDirSupermercado() +"; "+this.cantidadDeCajas()+". \n"+ aux;
    } 
}
