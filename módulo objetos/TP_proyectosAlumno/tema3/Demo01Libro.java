package tema3;
/**
 * @author vsanz
 */
public class Demo01Libro {
    public static void main(String[] args) {
        Autor au = new Autor("nom del autor", "bio del autor", "origen del autor");
        Libro libro = new Libro();
        libro.setTitulo("Java: A Beginner's Guide");
        libro.setEditorial("Mcgraw-Hill");
        libro.setAñoEdicion(2014);
        libro.setPrimerAutor(au);
        libro.setISBN("978-0071809252");
        libro.setPrecio(21.72);
        System.out.println(libro.toString());
       // System.out.println(libro); /* invoca automaticamente al metodo toString */

    }
    
}
