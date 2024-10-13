package parcial_te_2023;
/**
 * @author jGimenezruiz
 */
public class Cuenta {
    private String alias,moneda; 
    private int cbu,dniTitular;
    private double monto;

    public Cuenta(String alias, String moneda, int cbu, int dniTitular) {
        this.alias = alias;
        this.moneda = moneda;
        this.cbu = cbu;
        this.dniTitular = dniTitular;
        this.monto=0;
    }

    public double getMonto() {
        return monto;
    }

    private String getMoneda() {
        return moneda;
    }

    private int getCbu() {
        return cbu;
    }
    
    public boolean verificarCbu(int cbu){
        return this.getCbu()==cbu;
    }

    private void setMonto(double monto) {
        this.monto = monto;
    }
    
    public void incrementarMonto(double monto){
        this.setMonto(this.getMonto()+monto);
    }
    public boolean verificarSiLaCuentaEsEnDolar(){
        return this.getMoneda().equals("dolar");
    }
    public boolean verificarSiLaCuentaEsEnPesos(){
        return this.getMoneda().equals("pesos");
    }   
}
