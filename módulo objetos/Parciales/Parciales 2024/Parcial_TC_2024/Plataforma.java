package parcial_tc_2024;
/**
 * @author jGimenezruiz
 */
public class Plataforma {
    private String nomPlataforma;
    private int cantSuscriptores, fil, col,df;
    private Estreno [][]m;
    private int []v;

    public Plataforma(String nomPlataforma, int cantSuscriptores, int C) {
        this.nomPlataforma = nomPlataforma;
        this.cantSuscriptores = cantSuscriptores;
        this.fil = C;
        this.col=12;
        this.m = new Estreno[this.fil][this.col];
        this.v = new int[this.fil];
        for(int i=0;i<this.fil;i++) this.v[i]=0;
    }

    private String getNomPlataforma() {
        return nomPlataforma;
    }

    private int getCantSuscriptores() {
        return cantSuscriptores;
    }
    
    
    public void agregarEstreno(Estreno es, int X){
        this.m[X-1][this.v[X-1]]=es; this.v[X-1]++;
    }
    
    public String listaDeEstrenosDeLaCategoriaX(int X){
        String aux="";
        for(int i=0;i<this.v[X-1];i++){
            aux += this.m[X-1][i].toString()+"\n";
        }
        return aux;
    }
    
    public double gananciaTotalEnEstrenoDeSeries(){
       double suma=0;
        for(int i=0;i<this.fil;i++){
            for(int j=0;j<this.v[i];j++){
                suma += this.m[i][j].calculoGanancia();
            }
        }
        return suma;
    }

    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.fil;i++){
            aux += "Categoria "+(i+1)+": \n";
            for(int j=0;j<this.v[i];j++){
                aux +="Mes "+(j+1)+": \n"+this.m[i][j].toString();
            }
        }
        return "Plataforma: " +  this.getNomPlataforma() + ", " + this.getCantSuscriptores()+"\n"+aux;
    }
}
