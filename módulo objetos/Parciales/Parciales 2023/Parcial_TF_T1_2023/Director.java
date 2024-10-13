package parcial_tf_t1_2023;
/**
 * @author jGimenezruiz
 */
public class Director extends Empleados{
   private Double montoDes;

    public Director(String nom, int dni, int anioIngreso, Double sueldoBasico,double montoDes) {
        super(nom, dni, anioIngreso, 0);
        this.montoDes = montoDes;
    }
 
    public Double getMontoDes() {
        return montoDes;
    }
    
     @Override
    public double sueldoAcobrar(){
        return super.sueldoAcobrar()+this.getMontoDes();
    }
    @Override
    public String toString() {
        return super.toString()+", sueldo a cobrar: " + this.sueldoAcobrar();
    }
}
