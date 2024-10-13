package tema4;
/**
 * @author jGimenezruiz
 */
public abstract class Empleados { 
    private String nom;
    private double sueldo;
    private int  antiguedad;

    public Empleados(String nom, double sueldo, int antiguedad) {
        this.nom = nom;
        this.sueldo = sueldo;
        this.antiguedad = antiguedad;
    }
    
    @Override
    public String toString() {
        return "nom:" + this.nom + 
               ", sueldo: " + String.format("%.2f",this.calcularSueldoACobrar()) + 
               ", efectividad:" + String.format("%.2f", this.calcularEfectividad());
    }
    
    public double getSueldo() {
        return sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public abstract double calcularEfectividad();
    public double calcularSueldoACobrar(){
        return this.getSueldo()+0.1*this.getSueldo()*this.getAntiguedad();   
    }
}
