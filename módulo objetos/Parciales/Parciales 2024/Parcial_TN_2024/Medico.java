package parcial_tn_2024;
/**
 * @author jGimenezruiz
 */
public class Medico extends Persona{
    private String especialidad;
    private int  matricula;

    public Medico(String especialidad, int matricula, String ape, String nom, int dni, int cel) {
        super(ape, nom, dni, cel);
        this.especialidad = especialidad;
        this.matricula = matricula;
    }

    private String getEspecialidad() {
        return especialidad;
    }

    private int getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return super.toString()+" - Especialidad: " + this.getEspecialidad() + " - Matricula:" + this.getMatricula();
    }
}
