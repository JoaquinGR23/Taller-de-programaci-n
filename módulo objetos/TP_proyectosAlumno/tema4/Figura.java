package tema4;

public abstract class Figura {
    private String colorRelleno;
    private String colorLinea;
   
    public Figura(String unCR, String unCL){
        this.colorRelleno=unCR; 
        this.colorLinea=unCL;
    }
    
    @Override
    public String toString(){
        String aux = " Area: " + String.format("%.3f", this.calcularArea()) + 
                     " Perimetro: " + String.format("%.3f", this.calcularPerimetro())+ 
                     " CR: "  + getColorRelleno() + 
                      " CL: " + getColorLinea();             
             return aux;
       }
   
    public String getColorRelleno(){
        return colorRelleno;       
    }

    public String getColorLinea(){
        return colorLinea;       
    }

    public void despintar(){
        this.colorLinea="negro";
        this.colorRelleno="blanco";
    }
    
    /*<------------------------Encabezados de los métodos--------------------------->*/
    public abstract double calcularArea(); //Metodo que no tiene codigo y su implementacion se realiza en sus subclases
    public abstract double calcularPerimetro();
     
}
