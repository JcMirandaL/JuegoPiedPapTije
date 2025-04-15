import java.util.Random;
import java.util.Scanner;

public class juegoPiedPapTijeConMapsArray {
    
    //declaro global el scanner, el random y la variable ruta para poder usar en cualquier metodo
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();
    static String rutaEstadist = "C:/Users/julio/OneDrive/Documents/ProyectosJavaProgrEstruc2025VisualStudio/juegPiedPapTije/juegoPiedPapTijeConMapsArray.java";

    public static void main(String[] args) {
        //declaro e inicio variable
        int opcion = 0;

        //muestro mensajes
        System.out.println("<======================= MENU PRINCIPAL ==========================>");
        System.out.println("1. Jugar piedra, papel ó tijera");
        System.out.println("2. Mostrar Estadisticas");
        System.out.println("3. Salir");
        
        //bucle para validar solo opciones 1, 2 o 3
        do {
            //salto line
            System.out.println("");
            //solicito datos entrada
            System.out.println("Digite la opción deseada");
            //los leo y almaceno
            opcion = scan.nextInt();

            //Este para que entre a la opcion digitada y haga lo q tenga q hacer
            switch (opcion) {
                case 1:
                    //llamo al metodo jugar
                    jugar();
                    //se sale del switch
                    break;
                case 2: 
                    //llamo al metodo y q haga lo q tenga q hacer
                    mostrarEstadisticas();
                    //se sale de switch
                    break;
                case 3:
                    System.out.println("¡MUCHAS GRACIAS! Te esperamos pronto.");  
                    System.out.println("");  
                    //se sale de switch
                    break;
                default:
                    //si no es opcion 1,2 o 3 muestre este msj
                    System.out.println("ERROR: Digite una opción válida (1, 2 ó 3)");
                    //se sale de switch
                    break;
            }
        //si la opcion es mayo a 3 ó menor a 1 repite
        } while (opcion > 3 || opcion < 1);

    //cierre del main
    }


//cierre del algoritmo
}
