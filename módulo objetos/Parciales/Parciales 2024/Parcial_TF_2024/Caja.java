package parcial_tf_2024;
/**
 * @author jGimenezruiz
 */
public class Caja {
    private boolean disponible;
    private int df,dl;
    private Ticket []t;

    public Caja(int T) {
        this.disponible = true;
        this.dl=0;
        this.df = T;
        this.t=new Ticket[this.df];
    }

    private void cambiarDisponibilidad(boolean disponible) {
        this.disponible = disponible;
    }

    private boolean Disponible() {
        return disponible;
    }
    

    public void agregarTicket(Ticket t){
        if(this.dl<this.df){
            this.t[dl]=t; this.dl++;
        }
        else this.cambiarDisponibilidad(false);
    }
    public void cambio(int X){
        if((this.Disponible()) &&(this.hayMenosCantidad(X))) this.cambiarDisponibilidad(false);
    }
    private boolean hayMenosCantidad(int X){
        int cantidad=0;
        for(int i=0;i<this.dl;i++){
            cantidad += this.t[i].cantLibrosComprados();
        }
        if(cantidad<X) return true;
        else return false;
    }
    public Ticket obtenerTicketConElMayorMontoAbonadoDeLaCaja(){
        double monto,max=-1; Ticket ticketMax=null;
        for(int i=0;i<this.dl;i++){
            monto = this.t[i].montoAbonado();
            if(monto>max){
                max=monto; ticketMax=this.t[i];
            }
        }
        return ticketMax;
    }    

    @Override
    public String toString() {
        String aux="Tickets emitidos: [";
        for(int i=0;i<this.dl;i++){
            aux +=this.t[i].toString()+"; ";
        }
        aux +="]";
        return this.Disponible()+"; "+aux;
    } 
}
