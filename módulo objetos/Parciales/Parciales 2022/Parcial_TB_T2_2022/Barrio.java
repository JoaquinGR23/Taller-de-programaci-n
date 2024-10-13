package parcial_tb_t2_2022;
/**
 * @author jGimenezruiz
 */
public class Barrio {
   private String nomBarrio;
    private int N,M;
    private Lote [][] m;

    public Barrio(String nom, int N, int M) {
        this.nomBarrio = nom;
        this.N = N;
        this.M = M;
        this.m = new Lote[this.N][this.M];
        for(int i=0;i<this.N;i++){
            for(int j=0;j<this.M;j++) this.m[i][j]= new Lote();
        }
    }

    public String getNomBarrio() {
        return nomBarrio;
    }
    public void agregarComprador(Comprador c, int X, int Y){
       this.m[X-1][Y-1].agregarComprador(c);
    }
    public void incrementarPrecioALotes(int X, double porc){
        for(int i=0;i<this.M;i++){
            this.m[X-1][i].calculo(porc);
        }
    }
    public double totalRecaudado(){
        double monto=0;
        for(int i=0;i<this.N;i++){
            for(int j=0;j<this.M;j++) {
                if(this.m[i][j].hayComprador()) monto += this.m[i][j].getPrecio();
            }
        }
        return monto;
    }
    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.N;i++){
            aux += "Manzana #"+(i+1)+"|"+"\n";
            for(int j=0;j<this.M;j++) {
                aux += "-Lote #"+(j+1)+m[i][j].toString()+"\n";
            }
        }
        return "Barrio: " + this.getNomBarrio() +"\n"+ "Recaudacion actual: " + totalRecaudado() + "\n"+aux;
    } 
}
