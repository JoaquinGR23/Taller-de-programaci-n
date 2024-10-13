package tema4;
/**
 * @author jGimenezruiz
 */
public class Jugadores extends Empleados {
   private int partidosJug, goles;

    public Jugadores(int partidosJug, int goles,String nom, double sueldo, int antiguedad) {
        super(nom,sueldo,antiguedad);
        this.partidosJug = partidosJug;
        this.goles = goles;
    }

   @Override
    public double calcularEfectividad(){
        return (double)this.goles/this.partidosJug;
    }
   @Override
    public double calcularSueldoACobrar(){
        double sueldoConPlus = super.calcularSueldoACobrar();
        if(this.calcularEfectividad()>0.5) sueldoConPlus += this.getSueldo();
        return sueldoConPlus;
    }
    /*@Override
    public String toString() {
        return  super.toString()+
                " partidosJug: " +  partidosJug + 
                ", goles: " + goles;
    }  */ 
}
