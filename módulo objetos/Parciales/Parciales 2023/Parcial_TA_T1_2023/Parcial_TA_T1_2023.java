package parcial_ta_t1_2023;
/**
 * @author jGimenezruiz
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcial_TA_T1_2023 {
    public static void main(String[] args) {
        Fecha f = new Fecha(12, 12, 2024);
        Compra c1 = new Compra(123, 10, f);
        ConsumidorFinal c  = new ConsumidorFinal(12334, "consumidor final");
        f = new Fecha(21, 05, 2024);
        PorMayor c2 = new PorMayor(c, 124, 10, f);
        Producto p;
        GeneradorAleatorio.iniciar();
        for(int i=0;i<7;i++){
            p= new Producto(GeneradorAleatorio.generarInt(123)+3, GeneradorAleatorio.generarInt(10)+1, GeneradorAleatorio.generarDouble(453), GeneradorAleatorio.generarString(6)+1);
            c1.agregarProductos(p);
            p= new Producto(GeneradorAleatorio.generarInt(123)+3, GeneradorAleatorio.generarInt(10)+1, GeneradorAleatorio.generarDouble(453), GeneradorAleatorio.generarString(6)+1);
            c2.agregarProductos(p);
        }
        
        System.out.println("Resumen compra normal: ");
        System.out.println(c1.obtenerResumenDeLaCompra()+", abonables en cuotas: "+c1.saberSiEsAbonableEnCuotas());
        System.out.println("");
        
        System.out.println("precio : ");
        System.out.println(c2.precioPrueba());
        System.out.println("Resumen compra por mayor: ");
        System.out.println(c2.obtenerResumenDeLaCompra()+", abonables en cuotas: "+c2.saberSiEsAbonableEnCuotas());
        System.out.println("");   
    }   
}
