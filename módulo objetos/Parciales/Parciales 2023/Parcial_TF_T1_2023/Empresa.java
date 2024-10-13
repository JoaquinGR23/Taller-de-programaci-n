package parcial_tf_t1_2023;
/**
 * @author jGimenezruiz
 */
public class Empresa {
   private String nom, dir;
   private Director director;
   private int df;
   private Encargado [] suc;

    public Empresa(String nom, String dir, Director ejecutivo,int N) {
        this.nom = nom;
        this.dir = dir;
        this.director = ejecutivo;
        this.df = N;
        this.suc = new Encargado[this.df];
        for(int i=0;i<this.df;i++) suc[i] = null;
    }

    public String getNom() {
        return nom;
    }

    public String getDir() {
        return dir;
    }

    public void asignarEncargadoAUnaSucursal(int X,Encargado en){
        this.suc[X-1]=en;
    }
    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.df;i++){
            int k=i+1;
            if(suc[i]!=null) aux += "sucursal "+k+": "+ suc[i].toString()+" \n";
            else aux += "sucursal "+k+": no hay encargado en esa sucursal \n";
        }
        return "nom empresa: " + this.getNom() + 
                ", dir empresa: " + this.getDir() + 
                ", director: " + director.toString() + ", "+
                "Encargados: \n" + aux;
    }
}
