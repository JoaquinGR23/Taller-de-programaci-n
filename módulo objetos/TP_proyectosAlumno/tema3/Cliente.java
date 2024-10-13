package tema3;
/**
 * @author jGimenezruiz
 */
public class Cliente {
    private String nombre;
    private int edad,dni;

    public Cliente(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "nom: " + this.nombre + ", edad:" + this.edad + ", dni:" + this.dni+" ";
    }
}
