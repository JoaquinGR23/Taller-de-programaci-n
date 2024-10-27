package parcial_tj_2024;
/**
 * @author jGimenezruiz
 */
public class SitioTorneoProfesional extends Sitio{
    private int dl,df;
    private TorneoProfesional []t;

    public SitioTorneoProfesional(int N, String nom, String dirWeb) {
        super(nom, dirWeb);
        this.df = N;
        this.dl=0;
        this.t = new TorneoProfesional[this.df];
    }

    private int cantTorneosJugados() {
        return dl;
    }
   
    public boolean registrarTorneoProfesional(TorneoProfesional torneo){
        if(this.dl<this.df) {
            this.t[this.dl]=torneo; this.dl++; 
            return true;
        }
        else return false;
    }
    
    @Override
    public double cotizarSitio(){
        double monto=0;
        for(int i=0;i<this.dl;i++) monto += this.t[i].calculoMonto();
        return 1000*this.cantTorneosJugados()+ monto;
    }
}
