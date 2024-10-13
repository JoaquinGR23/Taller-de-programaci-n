package tema3;
/**
 * @author joaqu
 */
public class hotel {
    private habitacion [] v;
    private int df;
    private cliente [] vecCli; 

    public hotel(int df) {
        this.df = df;
        v = new habitacion[this.df];
        vecCli = new cliente[this.df];
        for (int i=0;i<this.df;i++) {
            v[i]=new habitacion(); vecCli[i]=null;
        }
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }

    /*public int getDl() {
        return dl;
    }

    public void setDl(int dl) { //No tendria que estar estos metodos?
        this.dl = dl;
    }*/
    public void aumentarMonto(double m){ 
        for(int i=0;i<df;i++)  v[i].setCosto(m);
    }
    public void agregarCliente(cliente cli, int hab){
        if(!v[hab-1].isOcupado()) v[hab-1].agregarCli(cli);
        else vecCli[hab-1]=cli;
    }

    @Override
    public String toString() {
        String aux="";
        for (int i=0;i<df;i++){
            int k=i+1;
            aux += "hab "+k+" "+ v[i].toString()+" ";
        }
        return aux;
    }
    
}
