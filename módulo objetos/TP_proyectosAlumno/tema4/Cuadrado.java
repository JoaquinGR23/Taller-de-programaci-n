package tema4;

public class Cuadrado extends Figura{
    private double lado;
    
    public Cuadrado(double unLado, String unColorR, String unColorL){
        super(unColorR,unColorL);
        this.lado=unLado;

    } 
    
    public double getLado(){
        return lado;       
    }

    @Override
    public double calcularArea(){
       return (getLado()* getLado());
    }
    
    @Override
    public double calcularPerimetro(){
       return (getLado()*4);
    }
    
    @Override
    public String toString(){
       String aux = super.toString() + 
                    " Lado: " + getLado();
       return aux;
    }
}
