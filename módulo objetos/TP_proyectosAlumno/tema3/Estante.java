package tema3;
/*
 * @author joaqu
 */
public class Estante {
    private int df=3,dl=0, df2;
    private Libro [] v;
    private Libro [] vec;//Creado sin usar para el INCISO C
    
    public Estante() {
      v = new Libro[df];
      for(int i=0;i<df;i++){
          v[i]= null;
      }
    }
    
    public Estante(int df) {
      this.df2 = df;
      vec = new Libro[df2];
      for(int i=0;i<this.df2;i++) vec[i]=null;
    }

    public boolean isHayEspacio() {
        return !(df==dl);
    }

    public int getDl() {
        return dl;
    }
    public void setAgregarLibro(Libro li){ //Deberia informar si se agrego el libro o no ?
        if(dl<df) {
            v[dl]= li; dl=dl+1;
        }
    }
    /*public boolean agregarLibro(Libro libro1){
       if(isHayEspacio()){
           v[dl++] = libro1;
           return true;
       }
       return false;
   }*/
    public Libro getLibroConNomParticular(String nom){
        int cont=0;
        while((cont<dl)&&(!(v[cont].getTitulo().equals(nom))))  cont++; 
        if((cont<dl)&&(v[cont].getTitulo().equals(nom))) return v[cont];
        else return null;
    }

    
}
