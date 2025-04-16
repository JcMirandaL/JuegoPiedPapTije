import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.classfile.instruction.DiscontinuedInstruction.RetInstruction;
import java.util.ArrayList;
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

            //llamo al metodo para ver la jugada de la compu
            computadora = jugadaComputadora();

            //llamo al metodo para saber si hay un ganador
            gano = validarGane(jugador, computadora);

            //valido para que entre solo si no hubo ganador
            if (gano.equals("")) {
                //si cumple llamo al metodo y que haga lo que tiene q hacer
                empate = validarEmpate(jugador, computadora, gano);
            }

            //llamo al metodo mostrar resultados y q haga lo que tenga q hacer
            mostrarResultados(jugador, computadora, gano, empate,nombre);

            //imprimo pregunta
            System.out.println("¿Desea volver a jugar? (Digite 1 para si ó 2 para no");
            //leo respuest
            volverJugar = scan.nextInt();

        //si volverJugar es igual a 1, repite
        } while (volverJugar == 1);

    //cierre del metodod jugar()    
    }

    //metodo para validar la jugada del jugador
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

    //metodo para validar la jugada de la compu
    public static String jugadaComputadora(){

        //declaro variable y la inicio en un random de 1 a 3
        int opc2 = random.nextInt(3) + 1;
        //declaro e inicio variable
        String jugadCompu = "";

        //validacion para ver que salio en el ramdom
        if (opc2 == 1) {

            //si cumple, actualizo variable jugadCompu
            jugadCompu = "PIEDRA";

        } else if (opc2 == 2){
            
            //Sino, si cumple este, actualizo variable jugadCompu
            jugadCompu = "PAPEL";
        }else {

            //Si no actualizo aqui la variable jugadCompu
            jugadCompu = "TIJERA";    
        }

        //devuelva lo que guardo en jugadCompu
        return jugadCompu.toUpperCase().trim();

    //cierre del metodo jugadaComputadora  
    }

    //metodo para alidar quien gano
    //en parametros llamo a jugador y computadora que es dnd estan almacenadas las jugadas de cd uno
    public static String validarGane(String jugador, String computadora){

        //declaro e inicio variable
        String ganador = "";

        //validacion para saber el ganador, en un lado el jugador y sus posibles combinaciones
        if (jugador.equals("PIEDRA") && computadora.equals("TIJERA") 
        || jugador.equals("PAPEL") && computadora.equals("PIEDRA")
        || jugador.equals("TIJERA") && computadora.equals("PAPEL")) {
            
            //si se cumple culaquiera de esas 3 combinaciones actualizo la variable ganador
            ganador = jugador;

        //Y en este otro lado la computadora y sus posibles combinaciones    
        } else if (computadora.equals("PIEDRA") && jugador.equals("TIJERA") 
        || computadora.equals("PAPEL") && jugador.equals("PIEDRA")
        || computadora.equals("TIJERA") && jugador.equals("PAPEL")) {
            
            //Sino, si se cumple culaquiera de esas 3 combinaciones actualizo la variable ganador
            ganador = computadora;
            
        }

        //devuelve lo que tiene la variable que seria ""
        return ganador;

    //cierre del metodo validarGane()    
    }

    //metodo para validar si hubo empate
    public static boolean validarEmpate(String jugador, String computadora, String gano){

        //declaro e inicio variable
        boolean empataron = true;

        //valido las 3 posibles combinaciones para un empate
        if (jugador.equals("PIEDRA") && computadora.equals("PIEDRA")
        || jugador.equals("PAPEL") && computadora.equals("PAPEL")
        || jugador.equals("TIJERA") && computadora.equals("TIJERA")) {

            //si cumple devuelva la variable empataron que esta en true
            return empataron;
            
        //si no    
        } else {
        
            //actualizo la variable
            empataron = false;
            //devuelve la variable actualizada
            return empataron;
        }

    //cierre del metodo validarEmpate()    
    }

    //metodo para mostrar results
    public static void mostrarResultados(String jugador, String computadora, String gano, boolean empate, String nombre){

        //salto
        System.err.println("");
        //imprimo msjs
        System.out.println("Piedra, Papel ó Tijera 1, 2, 3");
        System.out.println(nombre+ " escogio "+jugador);
        System.out.println("La computadora sacó "+computadora);

        //valido quien gano o si hubo empate para imprimir lo q corresponda
        if (gano.equals(jugador)) {

            //si entra aqui imprima esto
            System.out.println("¡FELICITACIONES! Le ganaste a la computadora");
            System.out.println("------------------------------------------------------");

        }else if (gano.equals(computadora)){

            //Sino, si entra aqui imprima esto otro
            System.out.println("!MALA SUERTE¡ La computadora te gano");
            System.out.println("------------------------------------------------------");

        }else if (empate == true){

            //Sino, si entra aqui imprima este otro
            System.out.println("!SORPRENDENTE¡ Ha ocurrido un empate");
            System.out.println("------------------------------------------------------");
        }

    //cierre del metodo mostrarResultados()    
    }


    /*------------------------------ Metodos para escribir archivo ------------------------------------- */

    //metodo para dar formato a las lineas y rellenar con "" los valores, si son mas pequeños que la cantCaracteres definidos
    public static String darFormatoConcatenarEspaciosBlanco(String valor, int cantCaracteres){

        //si valor es null 
        if (valor == null) {
            //pongale "" (vacio)
            valor = "";    
        }

        //si el tamaño de valor es mayor a la cantCaracteres
        if (valor.length() >= cantCaracteres) {

            //Entonces retorne el valor desde 0 a la cantCaracteres (recorta el resto)
            return valor.substring(0, cantCaracteres);

        //Sino    
        } else {
            //bucle para validar si valor es mas pequeño que cantCaracteres (repite mientras cantCarct es menor)
            while (valor.length() < cantCaracteres) {      

                //Que concatene "" (vacios) al resto
                valor = valor.concat(" ");

            }
            //devuelve el valor formateado
            return valor;
        }

    //cierre del metodo darFormatoConcatenarEspaciosBlanco()
    }

    //metodo para ir registrando los datos y definir el tamaño de cada valor, en parametros llamo lo que quiero registrar
    public static void registrarDatosJuego(String nombre, String cedula, String gano, boolean empate, String jugador, String computadora, String totPartidas){

        String linea = "", ganeJugador = "", ganeComputadora = "", empataron = "";

        //llamo al metodo y lo recibo en el valor correspondiente para definir el tamaño de carateres que tendra
        nombre = darFormatoConcatenarEspaciosBlanco(nombre, 15);
        cedula = darFormatoConcatenarEspaciosBlanco(cedula, 14);

        //valido quien gano
        if (gano.equals(jugador)) {

            //si gano jugador actualice estos con cada valor asignado
            ganeJugador = "1";
            ganeComputadora = "0";
            empataron = "0";
            totPartidas = "1";
            
        }else if (gano.equals(computadora)) {

            //si gano computadora actualice estos con cada valor asignado
            ganeJugador = "0";
            ganeComputadora = "1";
            empataron = "0";
            totPartidas = "1";

        }else {

            //si nade gano pongales esto
            ganeJugador = "0";
            ganeComputadora = "0";
            empataron = "1";
            totPartidas = "1";

        }
        //conformo la linea y le doy posicion a los datos en cada linea
        linea = nombre + cedula + ganeJugador + ganeComputadora + empataron + totPartidas;

        //llamo al metodo escribir para ir alamcenando datos registrados
        escribriArchivoJuego(linea);

    //cierre del metodo registrarDatosJuego()    
    }

    //metodo para escribir el archivo
    public static void escribriArchivoJuego(String linea){

        //intente
        try {
            //declaro e instancio en rutaEstadist(dnd esta guardada la ruta)
            File archivo = new File(rutaEstadist);
            
            //valido si e archivo no existe
            if (!archivo.exists()) {
                //creelo, por eso ese comando .create
                archivo.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaEstadist, true));
            //escribe la linea
            bw.write(linea);
            //salto de linea para q al escrib una linea salte a la siguiente 
            bw.newLine();
            //cierre del buffer
            bw.close();
   
        //sino pudo con lo del try (cuando se usa e.getMessage se le pone IO a la Exception, Sino, solo Exception e)  
        } catch (IOException e) {
            //imprima msj de error 
            System.out.println(e.getMessage());
        }

    //cierre del metodo escribriArchivoJuego()
    }

    /*-------------------------------------------Metodos para leer el archivo y luego mostrar estadisticas------------------------------------------------ */

    //metodo par leer el archivo que se escribio
    public static ArrayList<String> leerArchivoJuego(String rutaEstadist){

        //declaro ua lista dinamica
        ArrayList<String> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaEstadist))){

            //declaro e inicio variable
            String lineas = "";

            //bucle para ir leyendo cada linea de la lista
            while ((lineas = br.readLine()) != null) {

                //si lineas es diferente de vacio lea
                if (lineas.trim() != "") {
                    lista.add(lineas);
                }
            }
        //cierre del buffer
        br.close();
            
        //si no pudo hacer lo del catch
        } catch (Exception e) {

            //entonces imprima es msj
            System.out.println("ERROR: no se pudo leer el archivo");
            
        }

        return lista;
    //cierre de metodo leerArchivoJuego()    
    }

    //metodo para calcular la cantidad de filas 
    public static int calcularCantFilas(ArrayList<String> line){

        //aqui clono la lista para que los null no afecten a la lista original
        @SuppressWarnings("unchecked")
        ArrayList<String> lineas = (ArrayList<String>) line.clone();

        //declaro variabl y la defino con el total de lineas (con el array se usa size en vez de length)
        int cant = lineas.size();

        //bucle para recorrer las filas hasta la -1 xq en el primer recorrido ya he comparado la ultima fila
        for (int i = 0; i < lineas.size() - 1; i++) {
            //si lineas en la posicion i no es null que haga.
            //.get es obtener
            if (lineas.get(i) != null) {

                //bucle para recorrer las filas desde la posicion i+1 e ir comparando la posicion 0 con la 1, luego compara con el resto y asi en cada vuelta
                for (int j = i + 1; j < lineas.size(); j++) {
                    //si lineas en la posicion j no es null que haga.
                    if (lineas.get(j) != null) {

                        //si i y j no son null hace, y compara losindices de i y j desde el caracter 0 hasta el 14 de la linea que es dnd esta la ced 
                        if (lineas.get(i).substring(0,14).equals(lineas.get(j).substring(0,14))){
                            //si son equals(iguales) le resta 1 a cant que es dnd esta guardado la cantidad total de filas
                            cant--;
                            //Y tambien le pone un null al indice j
                            lineas.set(j, null);
                        }
                    }
                        
                }
            }
        } 
        //devuelve la cantidad de filas sin cedulas repetidas
        return cant;
    //cierre del metodo calcularCantFilas()    
    }

    //metodo para desmenusar los datos de la linea y meterlos en una matrz
    public static String[][] obtenerDatosJuego(ArrayList<String> lineas){

        //llamo al metodo calcularCantFilas y lo recibo en cantFil
        int cantFil = calcularCantFilas(lineas);

        //declaro e instancio la matrz dnd almacenare los datos
        String[][] matrzDatosJuego = new String[cantFil][6];

        //declaro e inicializo variable que va ir aumentando las filas nuevas
        int filaMatrz = 0;

        //bucle para recorrer las lineas, se usa valor para acceder al array.    : lineas (en esa posicion)
        for (String valor : lineas) {
            //defino variables y las inicio en la cantidad de caracteres para ir descomponiendo cada fila en varios datos, para eso el subString
            String nombre = valor.substring(0,15).trim();

            //del 15 al 29 posicion de cedula en la linea
            String cedula = valor.substring(15,29).trim();

            //caracteres del 29 al 32 posicion ganeJugador en la linea
            String ganeJugador = valor.substring(29,30).trim();

            //caracteres del 32 al 34 posicion ganeComputadora en la linea
            String ganeComputadora = valor.substring(30,31).trim();

            //caracteres del 34 al 36 posicion empataron en la linea
            String empataron = valor.substring(31,32).trim();

            //caracteres del 36 al 38 posicion totPartidas en la linea
            String totPartidas = valor.substring(32,33).trim();
            

            //llamo al metodod validarExisteJugador y lo recibo en posicion
            int posicion = validarExisteJugador(matrzDatosJuego, cedula);

            //valido si el valor retornado del metodo validarExisteJugador es -1 (jugador nuevo)entonces haga
            if(posicion == -1){
                //asigno las filas x cad vuelta +1 y asigno manual las columnas con su dato almacenado en cada posicion
                matrzDatosJuego[filaMatrz][0] = nombre;
                matrzDatosJuego[filaMatrz][1] = cedula;
                matrzDatosJuego[filaMatrz][2] = ganeJugador;
                matrzDatosJuego[filaMatrz][3] = ganeComputadora;
                matrzDatosJuego[filaMatrz][4] = empataron;
                matrzDatosJuego[filaMatrz][5] = totPartidas;
                //aqui aumenta la fila x vuelta +1    
                filaMatrz++;

            //si no, osea si es i lo que retorno (cedula repetida)   
            }else{
                //declaro e inicio variable en 0, que va amentar los ganes o empates y totPartidas, segun sea el caso 
                int conteo = 0, conteo2 = 0;

                //validaciones para ver quien gano y asi ir aumentado contador
                if (ganeJugador.equals("1")) {

                    //aqui paso la matriz a int 
                    conteo = Integer.parseInt(matrzDatosJuego[posicion][2].trim());
                    //y aqui paso el conteo a string y le suma 1 x cada vuelta que entre
                    matrzDatosJuego[posicion][2] = Integer.toString(++conteo); 

                }else if (ganeComputadora.equals("1")){

                    //aqui paso la matriz a int
                    conteo = Integer.parseInt(matrzDatosJuego[posicion][3].trim());
                    //y aqui paso el conteo a string y le suma 1 x cada vuelta que entre
                    matrzDatosJuego[posicion][3] = Integer.toString(++conteo);

                }else if (empataron.equals("1")){

                    //aqui paso la matriz a int
                    conteo = Integer.parseInt(matrzDatosJuego[posicion][4].trim());
                    //y aqui paso el conteo a string y le suma 1 x cada vuelta que entre
                    matrzDatosJuego[posicion][4] = Integer.toString(++conteo);

                }
                
                //esta otra validacion para aumentar el # de partidas 
                if (totPartidas.equals("1")){

                    //aqui paso la matriz a int
                    conteo2 = Integer.parseInt(matrzDatosJuego[posicion][5].trim());
                    //y aqui paso el conteo a string y le suma 1 x cada vuelta que entre
                    matrzDatosJuego[posicion][5] = Integer.toString(++conteo2);
                }
            }

        }    
       
        //devuelve a matrz con los datos en su posicion
        return matrzDatosJuego;

    //cierre del metodo obtenerDatosJuego()     
    }

    //metodo para validar cedulas repetidas, si no seria un jugador nuevo
    public static int validarExisteJugador(String[][] matrzDatosJuego, String cedula){

        //solo un bucle xq solo ocupo recorrer las filas en la posicion cedula
        for (int i = 0; i < matrzDatosJuego.length; i++) {

            //si matrz en la posicion i colum 1 es diferente de null 
            if (matrzDatosJuego[i][1] != null) {
                //si matrz en la posicion i colum 1 es igual a lo que tiene cedula
                if (matrzDatosJuego[i][1].trim().equals(cedula.trim())) {

                    //que devuelva la posicion dnd lo encontro(i)
                    return i;
                }
            }
        }
        //Si no que devuelva -1 que seria como vacio(jugador nuevo)
        return -1;

    //cierre del metodo validarExisteJugador()
    }

    //metodo para imprimir estadisticas
    public static void imprimirEstadisticas(){

        //llamo al metodo leerArchivo con la ruta de estadisticas y lo recibo en [] lineas
        ArrayList<String> lineas = leerArchivoJuego(rutaEstadist);

        //llamo al metodo obtenerDatosJuego y lo recibo en [][] matrzDatsJue
        String[][] matrzDatsJue = obtenerDatosJuego(lineas);

        //salto
        System.out.println("");
        //imprimo msj
        System.out.println("<==========================> ESTADISTICAS DEL JUEGO <=============================>");
        //salto
        System.out.println("");

        //bucle para recorrer las filas de la matrz
        for (int i = 0; i < matrzDatsJue.length; i++) {
            
            //imprimo resultds
            System.out.println("Total Ganes de " +matrzDatsJue[i][0]+ ": " +matrzDatsJue[i][2]+ " | Total Ganes Computadora: " +matrzDatsJue[i][3]);
            System.out.println("Total Empates: "+matrzDatsJue[i][4]);
            System.out.println("Total de Partidas " +matrzDatsJue[i][5]);
            System.out.println("------------------------------------------------------");
        }
    }    

//cierre del algoritmo
}
