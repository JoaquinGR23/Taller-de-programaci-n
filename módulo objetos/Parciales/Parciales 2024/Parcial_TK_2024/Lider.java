package parcial_tk_2024;
/**
 * @author jGimenezruiz
 */
public class Lider extends Programador{
    private int antiguedadEnAños, cantProyectosDirigidos;

    public Lider(int antiguedadEnAños, int cantProyectosDirigidos, String nomProgramador, String lenguajeDePreferencia, int dni, int cantLineasDeCodigoPorHora, double sueldo) {
        super(nomProgramador, lenguajeDePreferencia, dni, cantLineasDeCodigoPorHora, sueldo);
        this.antiguedadEnAños = antiguedadEnAños;
        this.cantProyectosDirigidos = cantProyectosDirigidos;
    }

    private int getAntiguedadEnAños() {
        return antiguedadEnAños;
    }

    private int getCantProyectosDirigidos() {
        return cantProyectosDirigidos;
    }

    @Override
    public double sueldoFinal(){
        return super.sueldoFinal()+this.getAntiguedadEnAños()*10000+ this.getCantProyectosDirigidos()*20000;
    }
}
