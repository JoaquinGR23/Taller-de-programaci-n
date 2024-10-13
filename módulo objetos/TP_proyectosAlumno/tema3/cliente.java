package tema3;
/**
 * @author joaqu
 */
public class cliente {
    private String nombre;
    private int edad,dni;

    public cliente(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "nom: " + nombre + ", edad:" + edad + ", dni:" + dni+" ";
    }

    

}
