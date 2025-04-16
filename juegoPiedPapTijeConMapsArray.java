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

    public static void jugar(){

        //declaro e inicializo variables
        String nombre = "", cedula = "";
        int volverJugar = 0;
        boolean empate = false;

        //declaro variables para recibir metodos
        String jugador, computadora, gano;

        //solicito datos entrada
        System.out.println("Digite su NOMBRE");
        //los leo (.toUpper = todo mayuscula, .trim = sin espacios)
        nombre = scan.next().toUpperCase().trim();

        //solicito datos entrada
        System.out.println("Digite su CÉDULA");
        //los leo (.toUpper = todo mayuscula, .trim = sin espacios)
        cedula = scan.next().toUpperCase().trim();
        //salto linea
        System.out.println("");

        //IMPRIMO MSJ
        System.out.println("¡EMPEZO EL JUEGO!");

        do {
            //llamo al metodo para ver la jugada del jugador
            jugador = jugadaJugador();

            //imprimo pregunta
            System.out.println("¿Desea volver a jugar? (Digite 1 para si ó 2 para no");
            //leo respuest
            volverJugar = scan.nextInt();

        //si volverJugar es igual a 1, repite
        } while (volverJugar == 1);

    //cierre del metodod jugar()    
    }

    public static String jugadaJugador(){

        //declaro e inicializo variables
        int opc = 0;

        //bucle para obligar a digitar una opcion valida 1, 2 ó 3
        do {
            //imprimo pregunta
            System.out.println("¿Que quiere usar? Digite la opcion 1, 2 ó 3");
            System.out.println("1.Piedra, 2.Papel, 3.Tijera");
            //leo resp
            opc = scan.nextInt();
            //salto
            System.out.println("");

            //VALIDO PARA MOSTRAR MSJS
            if (opc > 3 || opc < 1) {
                //si cumple imprima
                System.out.println("ERROR: Digite una opcion valida. (1, 2 ó 3)");    
                System.out.println("¡VUELVA A INTENTAR!");
                //salto
                System.out.println("");
            }

        //si la opc es mayor a 3 o menr a 1, repite    
        } while (opc > 3 || opc < 1);

        //validacion para retornar segun opcion digitada
        if (opc == 1) {
            
            return "PIEDRA";
        } else if (opc == 2){
            
            return "PAPEL";
        }else {

            return "TIJERA";
        }

    //cierre del metodo jugadaJugador()  
    }

//cierre del algoritmo
}
