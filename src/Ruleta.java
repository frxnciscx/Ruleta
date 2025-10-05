import java.util.Random;

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





}

