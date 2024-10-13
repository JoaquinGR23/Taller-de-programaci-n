package parcial_te_2023;
/**
 * @author jGimenezruiz
 */
public class Digital extends Banco {
    private String dirWeb;

    public Digital(String dirWeb, int N, String nom, int cantEmpleados) {
        super(N,nom,cantEmpleados);
        this.dirWeb = dirWeb;
    }

    @Override
    public  boolean puedeRecibirTarjeta(int cbu){
        Cuenta c = this.obtenerCuenta(cbu);
        if(c.verificarSiLaCuentaEsEnPesos() &&(c.getMonto()>100000)) return true;
        else return false;
    }
}
