package tema3;
/**
 * @author joaqu
 */
import PaqueteLectura.GeneradorAleatorio;
public class habitacion {
   private double costo;
   private cliente cli;
   private boolean ocupado;

    public habitacion() {
        this.costo = GeneradorAleatorio.generarDouble(6001)+2000;
        this.ocupado=false;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }


    public cliente getCli() {
        return cli;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    public void agregarCli(cliente cli) {
        this.cli = cli; ocupado=true;
    }

    @Override
    public String toString() {
        String aux="costo" +costo+ ", ocupado=" + ocupado+" ";
        if(ocupado) aux +=  cli.toString();
        return aux;
    }
   
   
}
