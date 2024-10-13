package parcial_te_2023;
/**
 * @author jGimenezruiz
 */
public class Tradicional extends Banco{
    private String dir,localidad;
    private int cantCuentas;

    public Tradicional(int N,String nom, int cantEmpleados) {
        super(N,nom,cantEmpleados);
        this.cantCuentas = 0;
    }

    private void setCantCuentas(int cantCuentas) {
        this.cantCuentas = cantCuentas;
    }

    private int getCantCuentas() {
        return cantCuentas;
    }
    @Override
    public  boolean puedeRecibirTarjeta(int cbu){
        Cuenta c = this.obtenerCuenta(cbu);
        if(c.verificarSiLaCuentaEsEnDolar() && (c.getMonto()>500)) return true;
        else if((c.verificarSiLaCuentaEsEnPesos())&&(c.getMonto()>70000)) return true;
        else return false;   
    }
    

    @Override
   public boolean agregarCuenta(Cuenta c){
       if(super.agregarCuenta(c)){
           if((this.getCantCuentas()<=100)&&(c.verificarSiLaCuentaEsEnDolar())) this.setCantCuentas(this.getCantCuentas()+1);
           return true;
       }
       else return false;
   }
}

