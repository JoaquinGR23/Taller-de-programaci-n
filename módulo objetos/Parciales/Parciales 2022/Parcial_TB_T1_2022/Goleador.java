package parcial_tb_2022;
/**
 * @author jGimenezruiz
 */
public class Goleador {
    private String nomGoleador, nomEquipo;
    private int cant;

    public Goleador(String nomGoleador, String nomEquipo, int cant) {
        this.nomGoleador = nomGoleador;
        this.nomEquipo = nomEquipo;
        this.cant = cant;
    }

    public String getNomGoleador() {
        return nomGoleador;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public int getCant() {
        return cant;
    }

    @Override
    public String toString() {
        return "{"+this.getNomGoleador()+", "+this.getNomEquipo()+", "+this.getCant()+"}";
    } 
}
