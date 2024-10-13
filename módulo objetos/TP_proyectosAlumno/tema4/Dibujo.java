package tema4;
/**
 * @author jGimenezruiz
 */
public class Dibujo {
  private String titulo;
  private Figura [] vector;
  private int guardadas,capacidadMaxima;

  public Dibujo (String titulo){
      this.titulo=titulo;
      this.capacidadMaxima=10;
      this.guardadas=0;
      vector = new Figura[this.capacidadMaxima];
  }

  public void agregar(Figura f){
    if(this.guardadas<this.capacidadMaxima) {
        this.vector[this.guardadas]=f; this.guardadas++;
        System.out.println("la figura" + f.toString() +" se ha guardado"); 
    }
  }

  public double calcularArea(){
    double area=0;
    for (int i=0;i<this.guardadas;i++) area += this.vector[i].calcularArea();
    return area;
  }
//imprime el título, representación de cada figura, y área del dibujo
  public void mostrar(){
    System.out.println("titulo: "+this.titulo);
    for(int i=0;i<this.guardadas;i++) {
        int k=i+1;
        System.out.println("Figura: "+k+" "+vector[i].toString()+" ");
    }
      System.out.println("Area del dibujo: "+this.calcularArea());
  }
//retorna está lleno el dibujo
  public boolean estaLleno() {
  return (guardadas == capacidadMaxima);
  }
}

