package parcial_tk_2024;
/**
 * @author jGimenezruiz
 */
public class Programador {
    private String nomProgramador, lenguajeDePreferencia;
    private int dni, cantLineasDeCodigoPorHora;
    private double sueldo;

    public Programador(String nomProgramador, String lenguajeDePreferencia, int dni, int cantLineasDeCodigoPorHora, double sueldo) {
        this.nomProgramador = nomProgramador;
        this.lenguajeDePreferencia = lenguajeDePreferencia;
        this.dni = dni;
        this.cantLineasDeCodigoPorHora = cantLineasDeCodigoPorHora;
        this.sueldo = sueldo;
    }

    private String getNomProgramador() {
        return nomProgramador;
    }

    private String getLenguajeDePreferencia() {
        return lenguajeDePreferencia;
    }

    private int getDni() {
        return dni;
    }
    
    private int getCantLineasDeCodigoPorHora() {
        return cantLineasDeCodigoPorHora;
    }

    private double getSueldo() {
        return sueldo;
    }

    private void cambiarSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    public double sueldoFinal(){
        if(this.getCantLineasDeCodigoPorHora()>200) return this.getSueldo()+50000;
        else return this.getSueldo();
    }
    public void aumentarSueldo(double M){
        this.cambiarSueldo(this.getSueldo()+M);
    }
    @Override
    public String toString() {
        return this.getNomProgramador() + ", " + this.getDni() + ", " + this.getLenguajeDePreferencia() + ", " + this.sueldoFinal();
    }
}
