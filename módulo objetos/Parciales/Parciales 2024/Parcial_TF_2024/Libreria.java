package parcial_tf_2024;
/**
 * @author jGimenezruiz
 */
public class Libreria {
    private String nom;
    private int numDeVenta,df;
    private Caja [] c;

    public Libreria(String nom, int T) {
        this.nom = nom;
        this.df = 4;
        this.numDeVenta=0;
        this.c = new Caja[this.df];
        for(int i=0;i<this.df;i++) this.c[i]= new Caja(T);
        
    }

    private String getNom() {
        return nom;
    }
    
    private int getNumDeVenta() {
        return numDeVenta;
    }

    private void setNumDeVenta(int numDeVenta) {
        this.numDeVenta = numDeVenta;
    }
    
    private Ticket generarTicket(int numTicket,int dniCli, int cantLibrosComprados, double monto, String medioDePago){
        return new Ticket(numTicket, dniCli, cantLibrosComprados, monto, medioDePago);
    }
    public void generarYAgregarTicket(int N,int dniCli, int cantLibrosComprados, double monto, String medioDePago){
        Ticket t = this.generarTicket(this.getNumDeVenta(), dniCli, cantLibrosComprados, monto, medioDePago);
        this.setNumDeVenta(this.getNumDeVenta()+1);
        this.c[N-1].agregarTicket(t);
    }
    public void cambiarDisponibilidad(int X){
        for(int i=0;i<this.df;i++){
            this.c[i].cambio(X);
        }
    }
    public Ticket ticketConMayorMontoAbonado(){
      double max=-1,monto; Ticket ticketMax=null,t;
        for(int i=0;i<this.df;i++){
            t = this.c[i].obtenerTicketConElMayorMontoAbonadoDeLaCaja();
            if(t!=null){
                if(t.montoAbonado()>max){
                    max = t.montoAbonado(); ticketMax=t;
                }
            }
        }
        return ticketMax;
    }

    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.df;i++){
            aux += "Caja "+(i+1)+": "+this.c[i].toString()+"\n";
        }
        return "Libreria: " +  this.getNom()+"; \n"+aux;
    } 
}
