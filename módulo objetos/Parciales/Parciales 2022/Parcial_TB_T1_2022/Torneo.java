package parcial_tb_2022;
/**
 * @author jGimenezruiz
 */
public class Torneo {
    private String nom;
    private int N,M;
    private Goleador [][] matriz;
    private int [] v;

    public Torneo(String nom, int N, int M) {
        this.nom = nom;
        this.N = N;
        this.M = M;
        this.matriz = new Goleador[this.N][this.M];
        this.v = new int[this.N];
        for(int i=0;i<this.N;i++) this.v[i]=0;
    }
    public void agregarGoleador(int X,Goleador gol){
        this.matriz[X-1][this.v[X-1]]=gol; this.v[X-1]++;
    }
    public Goleador obtenerGoleadorConMenosGoles(int X){
        int min=9999,cantGoles; Goleador gol=null;
        for(int i=0;i<this.v[X-1];i++) {
            cantGoles=this.matriz[X-1][i].getCant();
            if(cantGoles<min){
                min = cantGoles; gol=this.matriz[X-1][i];
            }
        }
        return gol;
    }
    public int cantidadDeGoleadoresEnElTorneo(){
        int cant=0;
        for(int i=0;i<this.N;i++){
            for(int j=0;j<this.v[i];j++) cant += 1;
        }
        return cant;
    }

    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.N;i++){
            int k=i+1;
            aux += "Fecha #"+k+"/ "+this.v[k-1]+"/ Goleadores: "; 
            for(int j=0;j<this.v[i];j++) {
              aux += this.matriz[i][j].toString();  
            }
            aux += "\n";
        }
        return "TORNEO 2022: " + this.nom + "\n"+aux;
    }
}
