package parcial_tb_t1_2023;
/**
 * @author jGimenezruiz
 */
public class Aula {
    private String nom;
    private int capacidad, df;
    private Alumno[]alu;

    public Aula(String nom, int N) {
        this.nom = nom;
        this.df= N;
        this.capacidad=0;
        this.alu=new Alumno[this.df];
    }
    public int cantDeAlumnosEnElAula(){
        return this.capacidad;
    }
    public void agregarAlumnoAlAula(Alumno alu){
        if(this.capacidad<this.df) {
            this.alu[capacidad]= alu; this.capacidad++;
        }
    }

    public String nomDelAula() {
        return nom;
    }
    public boolean buscarAlumnoYAsignarNota(int legajo, double nota){
        boolean encontre=false; int cont=0; 
        while((!encontre)&&(cont<this.capacidad)){
            if(this.alu[cont].getLegajo()==legajo) {
                this.alu[cont].asignarNota(nota); encontre=true;
            }
            else cont++;
        }
        return encontre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getNom() {
        return nom;
    }
    
    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.getCapacidad();i++){
            aux += this.alu[i].toString()+"\n";
        }
        return "Aula: " + this.getNom() + "\n"+aux;
    }   
}