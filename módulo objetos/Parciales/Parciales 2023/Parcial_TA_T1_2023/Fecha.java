package parcial_ta_t1_2023;
/**
 * @author jGimenezruiz
 */
public class Fecha {
    private int dia,mes,anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    private int getDia() {
        return dia;
    }

    private int getMes() {
        return mes;
    }

    private int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return "Fecha: (" +this.getDia()+"/"+this.getMes()+"/"+this.getAnio()+")";
    }
}
