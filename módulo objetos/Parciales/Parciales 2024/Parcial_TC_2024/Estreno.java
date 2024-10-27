package parcial_tc_2024;
/**
 * @author jGimenezruiz
 */
public class Estreno {
    private String titulo, tipoContenido;
    private double recaudacion;
    private int cantVisualizaciones;

    public Estreno(String titulo, String tipoContenido, double recaudacion, int cantVisualizaciones) {
        this.titulo = titulo;
        this.tipoContenido = tipoContenido;
        this.recaudacion = recaudacion;
        this.cantVisualizaciones = cantVisualizaciones;
    }

    private String getTitulo() {
        return titulo;
    }

    private String getTipoContenido() {
        return tipoContenido;
    }

    private double getRecaudacion() {
        return recaudacion;
    }

    private int getCantVisualizaciones() {
        return cantVisualizaciones;
    }
    private boolean esSerie(){
        return this.getTipoContenido().equals("serie");
    }
    public double calculoGanancia(){
        if(this.esSerie()) return (double)this.getRecaudacion()/2;
        else return 0;
    }
    @Override
    public String toString() {
        return  this.getTitulo() + ", " + 
                this.getTipoContenido() + ", " + 
                this.getRecaudacion() + ", " + 
                this.getCantVisualizaciones();
    }
    
    
    
}
