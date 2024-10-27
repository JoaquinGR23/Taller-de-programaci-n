package parcial_ta_2024;
/**
 * @author jGimenezruiz
 */
public class SalaRestringida extends Sala{
    private String contraseña;
    private int cantRechazadosPorContraseña;

    public SalaRestringida(String contraseña, String url, int id) {
        super(url, id);
        this.contraseña = contraseña;
        this.cantRechazadosPorContraseña = 0;
    }

    private String getContraseña() {
        return contraseña;
    }

    private int getCantRechazadosPorContraseña() {
        return cantRechazadosPorContraseña;
    }

    private void setCantRechazadosPorContraseña(int cantRechazadosPorContraseña) {
        this.cantRechazadosPorContraseña = cantRechazadosPorContraseña;
    }
    
    
    
    @Override
    public void agregarParticipante(Participante p){
        if(p.Contraseña().equals(this.getContraseña())) super.agregarParticipante(p);
        else this.setCantRechazadosPorContraseña(this.getCantRechazadosPorContraseña()+1);
    }
    
    @Override
    public void reiniciarSala(){
        super.reiniciarSala(); this.setCantRechazadosPorContraseña(0);
    }
    @Override
   public int totalSolicitudes(){
       return super.totalSolicitudes()+this.getCantRechazadosPorContraseña();
   }
   
}
