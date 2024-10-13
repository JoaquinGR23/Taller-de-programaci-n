package parcial_tb_t1_2023;
/**
 * @author jGimenezruiz
 */
public class Examen {
    private String fecha, enunciado;
    private Aula [] au;
    private int df;

    public Examen( Aula X, Aula Y) {
        this.au = new Aula[2];
        this.au[0]=X;
        this.au[1]=Y; 
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String agregarAlumnoAlExamen(Alumno au){
        if(this.au[0].cantDeAlumnosEnElAula()<this.au[1].cantDeAlumnosEnElAula()){
            this.au[0].agregarAlumnoAlAula(au); return this.au[0].nomDelAula();
        }
        else  {
            this.au[1].agregarAlumnoAlAula(au); return this.au[1].nomDelAula();
        }
    }
   
    public void asignarNota(int X, int legajo){
        if(!au[0].buscarAlumnoYAsignarNota(legajo,X)) au[1].buscarAlumnoYAsignarNota(legajo,X);
    }
    public int cantAlumnosQueRindenElExamen(){
        return this.au[0].cantDeAlumnosEnElAula()+this.au[1].cantDeAlumnosEnElAula();
    }

    public String getFecha() {
        return fecha;
    }
    
    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<2;i++){
            aux += au[i].toString();
        }
        return "Examen:" + " Fecha:" + this.getFecha() + ", cantidad de alumnos en total: " + cantAlumnosQueRindenElExamen()+
                "\n"+aux;
    }
}
