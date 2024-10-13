package parcial_te_2024;
/**
 * @author jGimenezruiz
 */
public class Caja {
    private String nomCajero;
    private int df,dl;
    private Ticket [] t;

    public Caja(String nomCajero, int T) {
        this.nomCajero = nomCajero;
        this.df = T;
        this.dl = 0;
        this.t=new Ticket[this.df];   
    }

    private String getNomCajero() {
        return nomCajero;
    }
    
    public void agregarTicket(Ticket t){
        if(this.dl<this.df){
            this.t[dl]=t; this.dl++;
        }
    }
  
    public int ticketsEmitidos(){
        int suma=0;
        for(int i=0;i<this.dl;i++){
            if(this.t[i].pagoConCredito()) suma ++;
        }
        return suma;
    }

    @Override
    public String toString() {
        String aux="[";
        for(int i=0;i<this.dl;i++){
            aux += this.t[i].toString()+";  ";
        }
        aux += "]";
        return this.getNomCajero()+"; "+"Tickets emitidos: "+aux;
    }  
}
