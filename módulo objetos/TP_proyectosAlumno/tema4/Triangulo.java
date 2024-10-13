package tema4;

public class Triangulo extends Figura{
    private double lado1, lado2, base, altura; 

    public Triangulo (double lado1, double lado2, double base, double altura, String unCR, String unCL) {
        super(unCR, unCL);
        this.lado1=lado1;
        this.lado2=lado2;
        this.base=base;
        this.altura=altura;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    @Override
     public double calcularArea(){
      return (double)(getBase()*getAltura())/2;
    }
    @Override
    public double calcularPerimetro(){
      return getLado1() + getLado2() + getBase();
    }

    @Override
    public String toString() {
        return "lado1: " + String.format("%.2f", this.lado1) +  
                ", lado2:" + String.format("%.2f", this.lado2) + 
                ", base: " + String.format("%.2f", this.base) + 
                ", altura: " + String.format("%.2f", this.altura)+
                super.toString();
    }
}
