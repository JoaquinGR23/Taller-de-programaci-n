package tema4;

public class Rectangulo extends Figura{
    private double base;
    private double altura;
    
    public Rectangulo(double base, double altura, String unColorR, String unColorL){
        super(unColorR,unColorL);
        this.base=base;
        this.altura=altura;
    } 

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double calcularArea() {
        return (getBase()*getAltura()); 
    }

    @Override
    public double calcularPerimetro() {
        return (2*getBase()+2*getAltura());
    }
    
    @Override
    public String toString(){
       String aux = super.toString() + 
                    " Base: " + getBase() +
                    " Altura: " + getAltura();
       return aux;
    }   
}
