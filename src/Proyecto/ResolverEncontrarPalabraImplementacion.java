package Proyecto;

import Libreria.Posicion;
import Libreria.ResolverEncontrarPalabraInterface;

import java.util.ArrayList;

public class ResolverEncontrarPalabraImplementacion implements ResolverEncontrarPalabraInterface {

    public ResolverEncontrarPalabraImplementacion() {
    }

    public ArrayList<Posicion> resolverEncontrarPalabra(char[][] matrizLetras, int longX, int longY, String palabraBuscar) {
        int tamanioPalabra = palabraBuscar.length();
        for (int fila=0; fila<longX; fila++) {
            for(int columna=0; columna<longY; columna++) {
                if (fila <= longY - tamanioPalabra || columna <= longX - tamanioPalabra){
                    if (matrizLetras[fila][columna] == palabraBuscar.charAt(0)){
                        int etapa = 1;
                        if (columna <= longY - tamanioPalabra){
                            ArrayList<Posicion> posibles = new ArrayList<>();
                            posibles = chequearDerecha(fila,columna,etapa,tamanioPalabra,posibles,matrizLetras,palabraBuscar);
                            if (posibles != null){
                                return posibles;
                            }
                        }
                        if(columna <= longY - tamanioPalabra && fila <= longX - tamanioPalabra ){
                            ArrayList<Posicion> posibles = new ArrayList<>();
                            posibles = chequearDiagonal(fila,columna,etapa,tamanioPalabra,posibles,matrizLetras,palabraBuscar);
                            if (posibles != null){
                                return posibles;
                            }
                        }
                        if (fila <= longX - tamanioPalabra){
                            ArrayList<Posicion> posibles = new ArrayList<>();
                            posibles = chequearAbajo(fila,columna,etapa,tamanioPalabra,posibles,matrizLetras,palabraBuscar);
                            if (posibles != null){
                                return posibles;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private ArrayList<Posicion> chequearDerecha(int fila, int columna, int etapa, int tamanioPalabra, ArrayList<Posicion> posibles,char[][] matrizLetras,String palabra) {
        Posicion posTemp = new Posicion();
        posTemp.posX = fila;
        posTemp.posY = columna;
        posibles.add(posTemp);
        if (etapa==tamanioPalabra){
            return posibles;
        }else{
            if(matrizLetras[fila][columna+1] == palabra.charAt(etapa)){
                return chequearDerecha(fila,columna+1,etapa+1,tamanioPalabra,posibles,matrizLetras,palabra);
            }else{
                return null;
            }
        }

    }

    private ArrayList<Posicion> chequearDiagonal(int fila, int columna, int etapa,int tamanioPalabra, ArrayList<Posicion> posibles,char[][] matrizLetras,String palabra) {
        Posicion posTemp = new Posicion();
        posTemp.posX = fila;
        posTemp.posY = columna;
        posibles.add(posTemp);
        if (etapa==tamanioPalabra){
            return posibles;
        }else{
            if(matrizLetras[fila+1][columna+1] == palabra.charAt(etapa)){
                return chequearDiagonal(fila+1,columna+1,etapa+1,tamanioPalabra,posibles,matrizLetras,palabra);
            }else{
                return null;
            }
        }
    }

    private ArrayList<Posicion> chequearAbajo(int fila, int columna, int k, int tamanioPalabra, ArrayList<Posicion> posibles,char[][] matrizLetras,String palabra) {
        Posicion posTemp = new Posicion();
        posTemp.posX = fila;
        posTemp.posY = columna;
        posibles.add(posTemp);
        if (k==tamanioPalabra){
            return posibles;
        }else{
            if(matrizLetras[fila+1][columna] == palabra.charAt(k)){
                return chequearAbajo(fila+1,columna,k+1,tamanioPalabra,posibles,matrizLetras,palabra);
            }else{
                return null;
            }
        }
    }
}