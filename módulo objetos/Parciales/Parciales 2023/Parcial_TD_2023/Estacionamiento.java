package parcial_td_2023;
/**
 * @author jGimenezruiz
 */
public class Estacionamiento {
    private String dir;
    private int S,V;
    private double costoPorHora;
    private Vehiculos [][]m;

    public Estacionamiento(String dir, int S, int V, double costoPorHora) {
        this.dir = dir;
        this.S = S;
        this.V = V;
        this.costoPorHora = costoPorHora;
        this.m= new Vehiculos[this.S][this.V];
        for(int i=0;i<this.S;i++){
            for(int j=0;j<this.V;j++) this.m[i][j]=null;
        }
    }

    private double getCostoPorHora() {
        return costoPorHora;
    }

    private String getDir() {
        return dir;
    }
 
    public void registrarVehiculo(Vehiculos v,int X, int Y){
        this.m[X-1][Y-1]=v; 
    }
    public String liberarEspacioDeUnSectorParticular(int X,String M){
        String aux="";
        for(int i=0;i<this.V;i++){
            if((this.m[X-1][i]!=null)&&(this.m[X-1][i].controlarMarca(M))) {
                aux +=this.m[X-1][i].toString()+"\n"; this.m[X-1][i]=null;
            }
        }
        return aux;
    }
    public int sectorConMasRecaudacionDeLaEstacion(){
         double max=-1,monto; int secMax=0;
        for(int i=0;i<this.S;i++){
            monto=0;
            for(int j=0;j<this.V;j++) {
                if(this.m[i][j]!=null) monto +=this.m[i][j].getCant()*this.getCostoPorHora();
            }
            if(monto>max){
                max = monto;  secMax=i+1;
            }
        }
        return secMax;
    }

    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.S;i++){
            aux +="Sector "+(i+1)+": \n";
            for(int j=0;j<this.V;j++) {
                aux +="Lugar "+(j+1)+": ";
                if(this.m[i][j]!=null) aux +=this.m[i][j].toString() +"\n";
                else aux +="no hay vehiculos \n";
            }
        }
        return "Estacionamiento: " + this.getDir() + ", "+this.getCostoPorHora()+"\n"+aux;
    }   
}