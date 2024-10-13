package tema3;
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Habitacion {
   private double costo;
   private Cliente cli;
   private boolean ocupado;

    public Habitacion() {
        this.costo = GeneradorAleatorio.generarDouble(6001)+2000;
        this.ocupado=false;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = this.costo+costo;
    }

    public Cliente getCli() {
        return cli;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void agregarCli(Cliente cli) {
        this.cli = cli; ocupado=true;
    }

    @Override
    public String toString() {
        String aux="costo" +costo+ ", ocupado=" + ocupado+" ";
        if(ocupado) aux +=  cli.toString();
        return aux;
    }
}
