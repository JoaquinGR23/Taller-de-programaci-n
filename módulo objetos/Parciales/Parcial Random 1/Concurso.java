package parcial.random.pkg1;
/**
 * @author jGimenezruiz
 */
public class Concurso {
    private Alumno al;
    private Alumno [][] alumno;
    private int fil,col;
    private int[] vec;

    public Concurso(int N) {
        this.fil = 5;
        this.col = N;
        this.alumno = new Alumno[this.fil][this.col];
        for(int i=0;i<this.fil;i++){
          for(int j=0;j<this.col;j++) this.alumno[i][j]=null;
        }
        vec = new int[this.col];
        for(int i=0;i<this.fil;i++) this.vec[i]=0; // para dim logica de cada genero
    }

    public void agregarAlumno(int genero, Alumno alu){
            if(this.vec[genero-1]<this.col)
            this.alumno[genero-1][this.vec[genero-1]] = alu; this.vec[genero-1]++;
    }
    public void agregarPuntajeADichoAlumnoo(double pun, String alu){
        int dlFil=0; boolean encontre=false; 
        while((dlFil<this.fil)&&(!encontre)){
          int dlCol=0;
            while((dlCol<vec[dlFil])&&(!encontre)){
              if(alumno[dlFil][dlCol].getNom().equals(alu)) {
                  encontre=true; alumno[dlFil][dlCol].setPuntaje(pun);
              }
            }
            dlFil++;
        }
    }
    public int generoMusicalConMasAlumnosInscriptos(){
        int max=0,generoMax=0;
        for(int i=0;i<this.fil;i++){
            int cont=0;
            for(int j=0;j<this.vec[i];j++) {
               cont++;  
          }
            if(cont>max) {
                max= cont; generoMax=i+1;
            }
        }
        return generoMax;
    }   
}
