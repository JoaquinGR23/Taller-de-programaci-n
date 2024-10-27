package parcial_ta_2024;
/**
 * @author jGimenezruiz
 */
public class Sala {
    private String url;
    private int id, df, dl, cantRechazadosPorFaltaDeEspacio;
    private Participante []v;

    public Sala(String url, int id) {
        this.url = url;
        this.id = id;
        this.dl=0;
        this.df=300;
        this.v = new Participante[this.df];
        this.cantRechazadosPorFaltaDeEspacio=0;
    }

    private String getUrl() {
        return url;
    }

    private int getId() {
        return id;
    }
    
    private int getCantRechazadosPorFaltaDeEspacio() {
        return cantRechazadosPorFaltaDeEspacio;
    }

    private void setCantRechazadosPorFaltaDeEspacio(int cantRechazadosPorFaltaDeEspacio) {
        this.cantRechazadosPorFaltaDeEspacio = cantRechazadosPorFaltaDeEspacio;
    }

    private int cantidadDeParticipantesConectados() {
        return dl;
    }
    
    public void agregarParticipante(Participante p){
        if(this.dl<this.df) {
            this.v[dl]=p; this.dl++;
        }
        else this.setCantRechazadosPorFaltaDeEspacio(this.getCantRechazadosPorFaltaDeEspacio()+1);
    }
    
    public void reiniciarSala(){
        for(int i=0;i<this.dl;i++) this.v[dl]=null;
        this.setCantRechazadosPorFaltaDeEspacio(0);
    }
    
    public int totalSolicitudes(){
        return this.cantidadDeParticipantesConectados()+this.getCantRechazadosPorFaltaDeEspacio();
    }
    public double calculoTasaDeAdmision(){
        return (double)100*this.cantidadDeParticipantesConectados()/this.totalSolicitudes();
    }


    public String resumen() {
        String aux="";
        for(int i=0;i<this.dl;i++) aux += this.v[i].toString()+"\n";
        aux += "Tasa de admision: "+this.calculoTasaDeAdmision();
        return "ID: " +this.getId() + 
                ", URL: "+this.getUrl()+
                "\n"+aux;
    }
}
