package parcial_td_2023;
/**
 * @author jGimenezruiz
 */
public class Vehiculos {
   private int pat,cant;
    private String marca,modelo;

    public Vehiculos(int pat, int cant, String marca, String modelo) {
        this.pat = pat;
        this.cant = cant;
        this.marca = marca;
        this.modelo = modelo;
    }

    private int getPat() {
        return pat;
    }

    public int getCant() {
        return cant;
    }

    private String getMarca() {
        return marca;
    }

    private String getModelo() {
        return modelo;
    }
    public boolean controlarMarca(String marca){
        return this.getMarca().equals(marca);
    }
    
    @Override
    public String toString() {
        return + this.getPat() + "," + this.getMarca() + ", " + this.getModelo() + ", " + this.getCant();
    }   
}
