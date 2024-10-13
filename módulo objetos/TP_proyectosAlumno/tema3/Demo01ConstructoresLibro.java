package tema3;
/**
 *
 * @author vsanz
 */
public class Demo01ConstructoresLibro {
    public static void main(String[] args) {
        Autor au = new Autor("nom del autor", "bio del autor", "origen del autor");
        Libro libro4=new Libro(); //objeto libro4 con referencia a la clase Libro
        System.out.println(libro4.getTitulo()); //variable de instancia del objeto sin referencia(NUL)
        Libro libro1= new  Libro( "Java: A Beginner's Guide",   //clase unTitulo tiene una referencia a "Java: A Beginner's Guide"
                                 "Mcgraw-Hill", 2014,   
                                 au, "978-0071809252", 21.72);
        Libro libro2= new Libro("Learning Java by Building Android Games",  
                              "CreateSpace Independent Publishing", 
                               au, "978-1512108347");
        System.out.println(libro1.getTitulo());
        libro1.setTitulo("libro nuevo"); //clase unTitulo tiene Nueva referencia a "libro nuevo"
        System.out.println(libro1.getTitulo());
        System.out.println("-----------");
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        System.out.println("Precio del libro2: " +libro2.getPrecio());
        System.out.println("Año edición del libro2: " +libro2.getAñoEdicion());
        Libro libro3= new Libro(); 
    } 
}
