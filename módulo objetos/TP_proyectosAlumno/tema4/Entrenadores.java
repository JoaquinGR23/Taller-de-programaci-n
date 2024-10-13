package tema4;
/**
 * @author jGimenezruiz
 */
public class Entrenadores extends Empleados {
    private int campeonatosGan;

    public Entrenadores(int camp,String nom, double sueldo, int antiguedad) {
        super(nom, sueldo, antiguedad);
        this.campeonatosGan=camp; 
    }

    @Override
    public double calcularEfectividad(){
        return(double)this.campeonatosGan/this.getAntiguedad();
    }
    @Override
    public double calcularSueldoACobrar(){
        double sueldoConPlus= super.calcularSueldoACobrar();
        if((this.campeonatosGan>=1)&&(this.campeonatosGan<=4)) sueldoConPlus += 5000;
        else if((this.campeonatosGan>=5)&&(this.campeonatosGan<=10)) sueldoConPlus += 30000;
        else if(this.campeonatosGan>10) sueldoConPlus += 50000;
        return sueldoConPlus;
    }
    /*@Override
    public String toString() {
        return super.toString()+
               "campeonatosGan: " + campeonatosGan;
    }*/
}
