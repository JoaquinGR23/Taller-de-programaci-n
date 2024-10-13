package parcial_te_2023;
/**
 * @author jGimenezruiz
 */
public abstract class Banco {
    private String nom;
    private int cant,df,dl;
    private Cuenta []c;

    public Banco(int N, String nom, int cantEmpleados) {
        this.nom= nom;
        this.cant=cantEmpleados;
        this.df = N;
        this.dl=0;
        this.c = new Cuenta[this.df];
    }
    
    public boolean agregarCuenta(Cuenta c){
        if(this.dl<this.df) {
            this.c[dl]=c; this.dl++; return true;
        }
        else return false;
    }
    public Cuenta obtenerCuenta(int cbu){ //EL CBU esta en el banco entonces por eso no hay control de si esta o no el CBU, seguro esta.
        int cont=0;
        while(!c[cont].verificarCbu(cbu)) cont++;
        return this.c[cont];
    }
    public void depositarDinero(int cbu, double monto){
        Cuenta cuen = this.obtenerCuenta(cbu);
        cuen.incrementarMonto(monto);
    }
    public abstract boolean puedeRecibirTarjeta(int cbu);    
}
