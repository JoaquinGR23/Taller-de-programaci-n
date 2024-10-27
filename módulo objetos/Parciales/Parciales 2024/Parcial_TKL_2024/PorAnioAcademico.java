package parcial_turnokl_2024;
/**
 * @author jGimenezruiz
 */
public class PorAnioAcademico extends Sistema{

    public PorAnioAcademico(Carrera carrera, int N) {
        super(carrera, N);
    }
    private int cantEgresadosPorAño(int anio){
        int suma=0;
        for(int i=0;i<4;i++){
            int valor = this.obtenerCantDeEgresadosDeUnAnioYTrimestreParticular(anio, i+1);
            if(valor!=-1) suma +=valor;
        }
        return suma;
    }
    @Override
    public String toString() {
        String aux="";
          for(int j=0;j<this.cantDeAniosAcademicos();j++){
              aux += "Año: "+(this.anioDeCreacion()+j)+" - "+this.cantEgresadosPorAño(this.anioDeCreacion()+j)+" egresados; ";
          }
        return super.toString()+aux;
    } 
}
