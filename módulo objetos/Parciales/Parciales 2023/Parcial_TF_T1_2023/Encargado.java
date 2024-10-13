package parcial_tf_t1_2023;
/**
 * @author jGimenezruiz
 */
public class Encargado extends Empleados{
    private int cantEmpACargo;

    public Encargado(String nom, int dni, int anioIngreso, int cantEmpACargo, double sueldoBasico) {
        super(nom, dni, anioIngreso, sueldoBasico);
        this.cantEmpACargo = cantEmpACargo;
    }
   
    public int getCantEmpACargo() {
        return cantEmpACargo;
    }

    @Override
    public double sueldoAcobrar(){ 
        return super.sueldoAcobrar()+this.getCantEmpACargo()*1000;
    }

    @Override
    public String toString() {
        return super.toString()+", sueldo a cobrar: " + this.sueldoAcobrar();
    }
}
