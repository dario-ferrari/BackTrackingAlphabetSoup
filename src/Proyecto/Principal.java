package Proyecto;

import Libreria.Posicion;
import java.util.ArrayList;

public class Principal {
    public Principal() {
    }

    public static void main(String[] args) {
        ResolverEncontrarPalabraImplementacion encontrarPalabra = new ResolverEncontrarPalabraImplementacion();
        int n = 5;
        int m = 6;
        char[][] matrizLetras = new char[n][m];
        matrizLetras[0][0] = 'c';
        matrizLetras[1][0] = 'n';
        matrizLetras[2][0] = 'u';
        matrizLetras[3][0] = 'p';
        matrizLetras[4][0] = 's';
        matrizLetras[0][1] = 'c';
        matrizLetras[1][1] = 'a';
        matrizLetras[2][1] = 'l';
        matrizLetras[3][1] = 'l';
        matrizLetras[4][1] = 'e';
        matrizLetras[0][2] = 'd';
        matrizLetras[1][2] = 'm';
        matrizLetras[2][2] = 's';
        matrizLetras[3][2] = 'r';
        matrizLetras[4][2] = 'i';
        matrizLetras[0][3] = 'f';
        matrizLetras[1][3] = 'i';
        matrizLetras[2][3] = 'm';
        matrizLetras[3][3] = 'a';
        matrizLetras[4][3] = 't';
        matrizLetras[0][4] = 'h';
        matrizLetras[1][4] = 'g';
        matrizLetras[2][4] = 'f';
        matrizLetras[3][4] = 'j';
        matrizLetras[4][4] = 'o';
        matrizLetras[0][5] = 'i';
        matrizLetras[1][5] = 'o';
        matrizLetras[2][5] = 'q';
        matrizLetras[3][5] = 'w';
        matrizLetras[4][5] = 'k';
        ArrayList<Posicion> posiciones = encontrarPalabra.resolverEncontrarPalabra(matrizLetras, n, m, "casa");
        imprimirPosiciones(posiciones);

        Matriz matriz = new Matriz();


/*      OBS : Para analisis complejidad practica, hay mas matrices en la clase matriz
        System.out.println("\nMatriz 20x20 duraznos");
        long startTime2 = System.nanoTime();
        ArrayList<Posicion> posiciones2 = encontrarPalabra.resolverEncontrarPalabra(matriz.matriz20x20Duraznos(), 20, 20, "duraznos");
        long stopTime2 = System.nanoTime();
        System.out.println(stopTime2 - startTime2);
        imprimirPosiciones(posiciones2);*/

    }

    private static void imprimirPosiciones(ArrayList<Posicion> posiciones) {
        System.out.println("Las posiciones en que se encuentra la palabra son:");
        for(int i = 0; i < posiciones.size(); ++i) {
            System.out.print("(" + ((Posicion)posiciones.get(i)).posX + ";" + ((Posicion)posiciones.get(i)).posY + ") - ");
        }
    }
}
