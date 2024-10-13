package parcial_t1_redictado2024;
/**
 * @author jGimenezruiz
 */
public class Turno {
    private String nomDocente; 
    private double sueldoDocente, costoCuota;
    private int df,dl;
    private Alumno [] a;

    public Turno(int N) {
        this.df = N;
        this.dl=0;
        this.a= new Alumno[this.df];
    }
    /////////////////////////////
    public void NomDocente(String nomDocente) { //Puede cambiar
        this.nomDocente = nomDocente;
    }

    public void SueldoDocente(double sueldoDocente) { //puede cambiar
        this.sueldoDocente = sueldoDocente;
    }

    public void CostoCuota(double costoCuota) { //puede cambiar
        this.costoCuota = costoCuota;
    }
    /////////////////////////////
    private String getNomDocente() {
        return nomDocente;
    }
    

    private double getSueldoDocente() {
        return sueldoDocente;
    }

    private double getCostoCuota() {
        return costoCuota;
    }

    private int cantidadAlumnosInscriptos() {
        return dl;
    }
    
    public void agregarAlumno(Alumno al){
        this.a[dl]=al; this.dl++;
    }
    public double recaudacion(){
        System.out.println(this.getCostoCuota()*this.cantidadAlumnosInscriptos()-this.getSueldoDocente());
        return (this.getCostoCuota()*this.cantidadAlumnosInscriptos()-this.getSueldoDocente());
    }

    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.dl;i++){
            aux +="Alumno"+(i+1)+": {"+this.a[i].toString()+"} ";
        }
        return this.getNomDocente() + ", " +aux;
    } 
}
