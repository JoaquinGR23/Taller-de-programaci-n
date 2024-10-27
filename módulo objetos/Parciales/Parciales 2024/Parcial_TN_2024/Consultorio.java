package parcial_tn_2024;
/**
 * @author jGimenezruiz
 */
public class Consultorio {
    private String nom, dir;
    private Medico medico;
    private int fil,col;
    private Paciente [][]m;

    public Consultorio(String nom, String dir, Medico medico, int N) {
        this.nom = nom;
        this.dir = dir;
        this.medico = medico;
        this.col = N;
        this.fil = 5;
        this.m = new Paciente [this.fil][this.col];
        for(int i=0;i<this.fil;i++){
            for(int j=0;j<this.col;j++) this.m[i][j]=null;
        }
    }

    private String getNom() {
        return nom;
    }

    private String getDir() {
        return dir;
    }
    
    
    public void asignarTurno(Paciente P, int T, int D){
        this.m[D-1][T-1]=P;
    }
    
    private int diaDeLaSemanaConMasTurnosDisponibles(){
        int diaMax=-1,max=-1;
        for(int i=0;i<this.fil;i++){
            int cont=0;
            for(int j=0;j<this.col;j++) {
                if(this.m[i][j]==null) cont++;
            }
            if(cont> max) {
                max = cont; diaMax=i+1;
            }
        }
        return diaMax;
    }
    
    public int cantidadDePacientesConObraSocialIngresada(String X){
        int cant=0;
        for(int i=0;i<this.fil;i++){
            for(int j=0;j<this.col;j++) {
                if((this.m[i][j]!=null)&&(this.m[i][j].esObraSocialIngresada(X))) cant++;
            }
        }
        return cant;
    }

    @Override
    public String toString() {
        String aux="";
        for(int i=0;i<this.fil;i++){
            aux += "Dia #"+(i+1)+": \n";
            for(int j=0;j<this.col;j++) {
                aux += "Turno "+(j+1)+": ";
                if(this.m[i][j]!=null) aux += this.m[i][j].toString()+"\n";
                else aux +="disponible \n";
            }
        }
        return "Consultorio: " + this.getNom() + 
                " - " + this.getDir() + 
                " - Dia de la semana con mas turnos disponibles: "+this.diaDeLaSemanaConMasTurnosDisponibles()+ 
                "\n Medico: "+ this.medico.toString()+
                "\n"+aux;
    }  
}
