import java.util.Random;
import java.util.Scanner;

public class Ruleta {

    //constantes y arreglos para guardar historial
    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;

    public static Random rng = new Random();

    //numeros rojos de la ruleta
    public static int[] numerosRojos = {1,3,5,7,9,12,14,16,18,19,21,23,27,30,32,34,36};

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner in = new Scanner(System.in);
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion(in);
            ejecutarOpcion(opcion, in);
        } while (opcion != 3);
        in.close();
    }

    //muestra las opciones en la pantalla
    public static void mostrarMenu(){
        System.out.println("==== MENU - BLACK CAT ====");
        System.out.println("1. Iniciar una ronda");
        System.out.println("2. Ver estadisticas");
        System.out.println("3. Salir");
    }

    //leer la opcion  del usuario
    public static int leerOpcion (Scanner in){
        System.out.print("Ingrese una opcion: ");
        int opcion= -1;
        try {
            opcion=Integer.parseInt(in.nextLine().trim());
        } catch (Exception e) {
            System.err.println("Entrada invalida");
        }
        if(opcion<1 || opcion>3){
            System.err.println("Opcion invalida");
        }
        return opcion;
    }

    //ejecutar lo que el usuario eligio
    public static void ejecutarOpcion(int opcion, Scanner in) {
        if (opcion == 1) {
            iniciarRonda(in);
        } else if (opcion == 2) {
            mostrarEstadisticas();
        } else if (opcion == 3) {
            System.out.println("Saliendo");
        } else {
            System.err.println("Opcion invalida");
        }
    }

    //iniciar una ronda de la ruleta
    public static void iniciarRonda(Scanner in) {
        System.out.println("Iniciar Ronda");
        char tipo = leerTipoApuesta(in);
        System.out.print("Ingrese monto a apostar: ");
        int monto = 0;
        try {
            monto = Integer.parseInt(in.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Monto invalido");
        }
        int numero=girarRuleta(); //genera numero aleatorio
        boolean acierto= evaluarResultado(numero,tipo); //evalua si gano
        registrarResultado(numero, monto, acierto); //guarda el resultado
        mostrarResultado(numero,tipo, monto, acierto); //muestra en la pantalla
    }






}

