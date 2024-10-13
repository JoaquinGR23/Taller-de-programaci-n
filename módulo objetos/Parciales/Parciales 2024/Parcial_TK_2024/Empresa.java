package parcial_tk_2024;
/**
 * @author jGimenezruiz
 */
public class Empresa {
    private String nomEmpresa;
    private Lider lider;
    private int df,dl;
    private Programador[] p;

    public Empresa(String nomEmpresa, Lider lider, int N) {
        this.nomEmpresa = nomEmpresa;
        this.lider = lider;
        this.df = N;
        this.p= new Programador[this.df];
        this.dl=0;
    }

    private String getNomEmpresa() {
        return nomEmpresa;
    }
    
    public void agregarProgramadorALaEmpresa(Programador p){
        if(this.dl<this.df){
            this.p[dl]=p; this.dl++;
        }
    }
    private double calculoSueldoDeLaEmpresa(){
        double sueldo=0;
        for(int i=0;i<this.dl;i++){
            sueldo +=this.p[i].sueldoFinal();
        }
        sueldo +=lider.sueldoFinal();
        return sueldo;
    }
    public void aumentarSueldoBasico(double M){
        for(int i=0;i<this.dl;i++){
            this.p[i].aumentarSueldo(M);
        }
        this.lider.aumentarSueldo(M);
    }

    @Override
    public String toString() {
        String aux="Programador Lider: {"+this.lider.toString()+"} \n";
        for(int i=0;i<this.dl;i++){
            aux +="Programador "+(i+1)+": {"+this.p[i].toString()+"} \n";
        }
        return "Empresa: " + this.getNomEmpresa() + ". \n"+aux+
                "Monto total en sueldos a abonar por la empresa: "+this.calculoSueldoDeLaEmpresa();
    }
}
