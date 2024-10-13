package tema3;
/**
 *
 * @author jGimenezruiz
 */

public class Triangulo {
    private double lado1,lado2,lado3;
    private String colorL, colorR;

    public Triangulo(double lado1, double lado2, double lado3, String colorL, String colorR) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.colorL = colorL;
        this.colorR = colorR;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public String getColorL() {
        return colorL;
    }

    public void setColorL(String colorL) {
        this.colorL = colorL;
    }

    public String getColorR() {
        return colorR;
    }

    public void setColorR(String colorR) {
        this.colorR = colorR;
    }
    
    public double calcularPerimetro(){
        return lado1+lado2+lado3;
    }
    public double calcularArea(){
       double s=(lado1+lado2+lado3)/2;
       return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
    }
    @Override
    public String toString() {
        return "lado1:" + lado1 + ", lado2:" + lado2 + ", lado3:" + lado3 + ", colorL=" + colorL + ", colorR=" + colorR;
    }

    
}
