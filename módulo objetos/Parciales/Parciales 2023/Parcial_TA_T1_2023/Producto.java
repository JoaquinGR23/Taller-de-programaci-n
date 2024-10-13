package parcial_ta_t1_2023;
/**
 * @author jGimenezruiz
 */
public class Producto {
   private int codProd, cantUnidades;
    private double precioUnitario;
    private String descripcion;

    public Producto(int codProd, int cantProd, double precio, String descripcion) {
        this.codProd = codProd;
        this.cantUnidades = cantProd;
        this.precioUnitario = precio;
        this.descripcion = descripcion;
    }

    private int getCodProd() {
        return codProd;
    }

    public int getCantProd() {
        return cantUnidades;
    }

    private double getPrecio() {
        return precioUnitario;
    }

    private String getDescripcion() {
        return descripcion;
    }


    public double precioFinal(){
        return (double)this.getCantProd()*this.getPrecio();
    }
    @Override
    public String toString() {
        return "Producto -"+"cod de producto: " + this.getCodProd() + ", descripcion: " + this.getDescripcion() + ", precio final del producto:" + this.precioFinal();
    }
    
    
}
