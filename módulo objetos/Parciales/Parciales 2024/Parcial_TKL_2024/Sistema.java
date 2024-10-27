package parcial_turnokl_2024;
/**
 * @author jGimenezruiz
 */
public abstract class Sistema {
    private Carrera car;
    private int fil,col;
    private int [][]m;

    public Sistema(Carrera carrera, int N) {
        this.car = carrera;
        this.fil = N;
        this.col = 4;
        this.m = new int[this.fil][this.col];
        for(int i=0;i<this.fil;i++){
            for(int j=0;j<this.col;j++) this.m[i][j]=-1;
        }
    }

    public int cantDeAniosAcademicos() {
        return fil;
    }

    public int anioDeCreacion(){
        return this.car.anioDeCreacion();
    }
    
    
    public void registrarCantDeEgresados(int cant, int X, int Y){
        this.m[X-this.anioDeCreacion()][Y-1]=cant;
    }
    public int obtenerCantDeEgresadosDeUnAnioYTrimestreParticular(int X,int Y){ 
        return this.m[X-this.anioDeCreacion()][Y-1];
    }
    
    @Override
    public String toString() {
        return this.car.toString()+"\n";
    } 
}
