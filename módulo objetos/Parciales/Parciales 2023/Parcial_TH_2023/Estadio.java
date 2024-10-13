package parcial_th_2023;
/**
 * @author jGimenezruiz
 */
public class Estadio {
    private String nomEstadio,dir;
    private int capacidad, N,M;
    private Concierto [][] c;
    private int [] v;

    public Estadio(String nomEstadio, String dir) {
        this.nomEstadio = nomEstadio;
        this.dir = dir;
        this.N = 12;
        this.M = 31;
        this.c = new Concierto[this.N][this.M];
        this.capacidad = this.N * this.M;
        this.v = new int[this.N];
        for(int i=0;i<this.N;i++) this.v[i]=0;
    }

    private String getNomEstadio() {
        return nomEstadio;
    }

    private String getDir() {
        return dir;
    }

    private int getCapacidad() {
        return capacidad;
    }
    
    public void registrarConcierto(int mes, Concierto c){
        if((mes <= this.N)&&(this.v[mes-1]<this.M)) {
            this.c[mes-1][this.v[mes-1]]=c; this.v[mes-1]++;
        } 
    }
    public String listaDeConciertosDelMesIngresado(int mes){
        String aux="";
        if((mes>=1)&&(mes<=this.N)) {
            for(int i=0;i<this.v[mes-1];i++) aux += this.c[mes-1][i].toString()+"\n";
        }
        return aux;
    }
    public double calcularGananciaEnElMesIngresado(int mes){
        double monto=0;
        if((mes>=1)&&(mes<=this.N)){
            for(int i=0;i<this.v[mes-1];i++) monto += this.c[mes-1][i].calcularGanancia();
        }
        return (double)monto/2;
    }
    
    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.N;i++){
            int k=i+1;
            aux += "Mes "+k+": \n";
            for(int j=0;j<this.v[i];j++){
              int n=j+1;
                aux += "Dia "+n+": "+ c[i][j].toString()+"\n";
            }
        }
        return "Estadio: " + this.getNomEstadio() + ", " +  this.getDir()+ ", "+ this.getCapacidad()+ "\n"+aux;
    }
}
