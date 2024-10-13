package tema3;
/**
 * @author jGimenezruiz
 */
public class Hotel {
    private Habitacion [] v;
    private int df;

    public Hotel(int df) {
        this.df = df;
        v = new Habitacion[this.df];
        for (int i=0;i<this.df;i++) {
            v[i]=new Habitacion(); 
        }
    }
    public void aumentarMonto(double m){ 
        for(int i=0;i<df;i++)  v[i].setCosto(m);
    }
    public void agregarCliente(Cliente cli, int hab){
        if(!v[hab-1].isOcupado()) v[hab-1].agregarCli(cli);
    }

    @Override
    public String toString() {
        String aux="";
        for (int i=0;i<df;i++){
            int k=i+1;
            aux += "hab "+k+" "+ v[i].toString()+" \n";
        }
        return aux;
    }   
}
