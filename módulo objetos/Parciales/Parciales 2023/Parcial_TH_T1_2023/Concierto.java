package parcial_th_2023;
/**
 * @author jGimenezruiz
 */
public class Concierto {
   private String nomArtista;
    private double precio;
    private int cant;

    public Concierto(String nomArtista, double precio, int cant) {
        this.nomArtista = nomArtista;
        this.precio = precio;
        this.cant = cant;
    }

    private String getNomArtista() {
        return nomArtista;
    }

    private double getPrecio() {
        return precio;
    }

    private int getCant() {
        return cant;
    }
    public double calcularGanancia(){
        return this.getCant()*this.getPrecio();
    }

    @Override
    public String toString() {
        return this.getNomArtista() + ", " + this.getPrecio()+ ", "+ this.getCant();
    }
}
