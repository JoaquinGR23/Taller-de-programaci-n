package tema3;
/**
 * @author vsanz
 */
public class Libro {
   /*<------------------------ATRIBUTOS DEL OBJETO--------------------------->*/
   private String titulo;
   private autor primerAutor; 
   private String editorial;
   private int añoEdicion;
   private String ISBN; 
   private double precio; 
     
    /*<------------------------COMPORTAMIENTOS DEL OBJETO--------------------------->*/
    public Libro(  String unTitulo,  String unaEditorial, 
    int unAñoEdicion,  autor unPrimerAutor, String unISBN, double unPrecio){
         titulo = unTitulo;
         editorial = unaEditorial; 
         añoEdicion= unAñoEdicion;
         primerAutor = unPrimerAutor;
         ISBN =  unISBN;
         precio = unPrecio;
    }
    
    public Libro(  String unTitulo,  String unaEditorial, autor unPrimerAutor, String unISBN){
         titulo = unTitulo;
         editorial = unaEditorial; 
         añoEdicion= 2015;
         primerAutor = unPrimerAutor;
         ISBN =  unISBN;
         precio = 100;
    }
    
    public Libro(){
   
    }
        
    public String getTitulo(){
        return titulo;
    }
  
    public String getEditorial(){
        return editorial;
    }
    public int getAñoEdicion(){
        return añoEdicion;
    }
    //parte del autor (PREGUNTAR)
    public autor getPrimerAutor(){
        return primerAutor;
    } 
    public void setPrimerAutor(autor unPrimerAutor){
         primerAutor=unPrimerAutor;
    } 
    //Otra forma:  
    public String getNombreDelAutor(){
        return primerAutor.getNom();
    }
    public String getBiografiaDelAutor(){
        return primerAutor.getBio();
    }
    public String getOrigenDelAutor(){
        return primerAutor.getOrigen();
    }
    public String getToStringDelAutor(){
        return primerAutor.toString();
    }
    
    public void setNombreDelAutor(String nom){
        primerAutor.setNom(nom);
    }
    public void setBiografiaDelAutor(String bio){
        primerAutor.setBio(bio);
    }
    public void setOrigenDelAutor(String origen){
        primerAutor.setOrigen(origen);
    }
    //////////////////////////////////////////
    
    public String getISBN(){
        return ISBN;
    }
    public double getPrecio(){
        return precio;
    }
   
    public void setTitulo(String unTitulo){
        titulo = unTitulo;
    }
   
    public void setEditorial(String unaEditorial){
         editorial = unaEditorial;
    }
    public void setAñoEdicion(int unAño){
         añoEdicion = unAño;
    }
   
    
    public void setISBN(String unISBN){
         ISBN=unISBN;
    } 
    public void setPrecio(double unPrecio){
         precio=unPrecio;
    }
   
    
   @Override //Para sobreescribir el toString por defecto de java
    public String toString(){
        String aux;
        aux= titulo + " por " + primerAutor.toString() + " - " + añoEdicion + " - " + " ISBN: " + ISBN;
       return ( aux);
    }
        
}
