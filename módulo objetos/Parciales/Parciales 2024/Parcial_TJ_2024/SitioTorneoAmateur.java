package parcial_tj_2024;
/**
 * @author jGimenezruiz
 */
public class SitioTorneoAmateur extends Sitio {
    private int cantTorneosJugados, cantClicksEfectuados;

    public SitioTorneoAmateur(String nom, String dirWeb) {
        super(nom, dirWeb);
        this.cantTorneosJugados = 0;
        this.cantClicksEfectuados = 0;
    }

    private int getCantTorneosJugados() {
        return cantTorneosJugados;
    }

    private void setCantTorneosJugados(int cantTorneosJugados) {
        this.cantTorneosJugados = cantTorneosJugados;
    }

    private void setCantClicksEfectuados(int cantClicksEfectuados) {
        this.cantClicksEfectuados = cantClicksEfectuados;
    }
    
    
    private int CantClicksEfectuados() {
        return cantClicksEfectuados;
    }
    
    public void registrarTorneoAmateur(int cantClicks){
        this.setCantClicksEfectuados(this.CantClicksEfectuados()+cantClicks);
        this.setCantTorneosJugados(this.getCantTorneosJugados()+1);   
    }
    
    @Override
    public double cotizarSitio(){
       return 10*this.CantClicksEfectuados()+50*this.cantUsuReg();
    }    
}
