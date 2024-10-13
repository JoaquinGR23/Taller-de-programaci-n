package parcial_tf_t1_2023;
/**
 * @author jGimenezruiz
 */
public abstract class Empleados {
    private String nom;
    private int dni,anioIngreso;
    private double sueldoBasico;

    public Empleados(String nom, int dni, int anioIngreso, double sueldoBasico) {
        this.nom = nom;
        this.dni = dni;
        this.anioIngreso = anioIngreso;
        this.sueldoBasico = sueldoBasico;
    }

    public String getNom() {
        return nom;
    }
    
    public int getDni() { 
        return dni;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public double getSueldoBasico() { 
        return sueldoBasico;
    }

    public double sueldoAcobrar(){
        if((2024-this.getAnioIngreso())>20) return this.getSueldoBasico()+0.1*this.getSueldoBasico();
        else return this.getSueldoBasico();
    }
    @Override
    public String toString() {
        return  "nom: " + this.getNom() + 
                ", dni: " + this.getDni();
    }
}
