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
    public static int[] numerosRojos = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 27, 30, 32, 34, 36};

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
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
    public static void mostrarMenu() {
        System.out.println("==== MENU - BLACK CAT ====");
        System.out.println("1. Iniciar una ronda");
        System.out.println("2. Ver estadisticas");
        System.out.println("3. Salir");
    }

    //leer la opcion  del usuario
    public static int leerOpcion(Scanner in) {
        System.out.print("Ingrese una opcion: ");
        int opcion = -1;
        try {
            opcion = Integer.parseInt(in.nextLine().trim());
        } catch (Exception e) {
            System.err.println("Entrada invalida");
        }
        if (opcion < 1 || opcion > 3) {
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
        int numero = girarRuleta(); //genera numero aleatorio
        boolean acierto = evaluarResultado(numero, tipo); //evalua si gano
        registrarResultado(numero, monto, acierto); //guarda el resultado
        mostrarResultado(numero, tipo, monto, acierto); //muestra en la pantalla
    }

    //permite elegir tipo de apuesta
    public static char leerTipoApuesta(Scanner in) {
        System.out.println("Ingrese tipo de apuesta");
        System.out.println("R (ROJO), N (NEGRO), P (PAR), I (IMPAR);  ");
        String s = in.nextLine().trim().toUpperCase();
        if (s.isEmpty()) s = " ";
        char tipo = s.charAt(0);
        return tipo;
    }

    //girar la ruleta (0 a 36)
    public static int girarRuleta() {
        int numero = rng.nextInt(37);
        System.out.print("Girando la ruleta... ");
        return numero;
    }

    //evalua si el jugador acerto
    public static boolean evaluarResultado(int numero, char tipo) {
        if (tipo == 'R') {
            return esRojo(numero);
        }
        if (tipo == 'N') {
            return !esRojo(numero) && numero !=0;
        }
        if (tipo == 'P') {
            return numero !=0 && numero %2==0;
        }
        if (tipo == 'I') {
            return numero %2==1;
        }
        return false;
    }

    //verifica si el numero es rojo
    public static boolean esRojo(int n) {
        if (n == 0) return false;
        for (int r : numerosRojos) {
            if (r == n) return true;
        }
        return false;
    }

    //guarda el resultado en el historial
    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
        if (historialSize >= MAX_HISTORIAL) {
            System.out.println("Historial lleno");
            return;
        }
        historialNumeros[historialSize] = numero;
        historialApuestas[historialSize] = apuesta;
        historialAciertos[historialSize] = acierto;
        historialSize++;
    }

    //muestra el resultado al jugador
    public static void mostrarResultado(int numero, char tipo, int monto, boolean acierto) {
        System.out.println("Numero: " + numero);
        System.out.println("Apuesta: " + tipo);
        System.out.println("Monto: " + monto);
        System.out.println(acierto? "Ganaste! " : "Perdiste :(");
        System.out.println("Presione Enter para continuar");
        new Scanner(System.in).nextLine();
    }







}

