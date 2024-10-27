package parcial_turnokl_2024;
/**
 * @author jGimenezruiz
 */
public class PorTrimestre extends Sistema{

    public PorTrimestre(Carrera carrera, int N) {
        super(carrera, N);
    }    
    
    public int obtenerLaCantidadDeTrimestresQueRegistranXEgresados(int X){
        int tri=0;
        for(int i=0;i<4;i++){
          int cant=0;
          for(int j=0;j<this.cantDeAniosAcademicos();j++) {
              int valor = this.obtenerCantDeEgresadosDeUnAnioYTrimestreParticular(this.anioDeCreacion()+j, i+1);
              if(valor!=-1) cant +=valor;
          }
            if(cant==X) tri++;
        }
        return tri;
    }
    
    private int sumaEgresadosPorTrimestre(int tri){
        int suma=0;
        for(int j=0;j<this.cantDeAniosAcademicos();j++) {
              int valor = this.obtenerCantDeEgresadosDeUnAnioYTrimestreParticular(this.anioDeCreacion()+j, tri+1);
              if(valor!=-1) suma +=valor;
          }
        return suma;
    }

    @Override
    public String toString() {
        String aux=""; 
        for(int i=0;i<4;i++){ 
            aux +="Trimestre "+(i+1)+": "+this.sumaEgresadosPorTrimestre(i)+" egresados; ";
        }
        return super.toString()+aux;
    }
}
