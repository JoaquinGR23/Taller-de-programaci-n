package tema3;
/*
 * @author jGimenezruiz
 */
public class Estante {
    private int df,dl;
    private Libro [] v;
    
    public Estante() {
      this.df =3;
      this.v = new Libro[this.df];
      this.dl=0;
    }
    
    public Estante(int df) {
      this.df = df;
      this.v = new Libro[this.df];
      this.dl=0;
    }

    public boolean isHayEspacio() {
        return !(df==dl);
    }

    public int cantidadLibrosAlmacenados() {
        return dl;
    }
    public void agregarLibro(Libro li){ 
        if(dl<df) {
            v[dl]= li; dl=dl+1;
        }
    }
    /*public boolean agregarLibro(Libro libro1){ //EN CASO QUE QUIERA INFORMAR SI HAY O NO ESPACIO 
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
