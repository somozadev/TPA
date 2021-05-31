package test;

import javax.swing.DebugGraphics;

/**
 * 
 * @author Marcos Somoza Corral
 * @expediente 21711787
 * @fecha 13-04-2021
 *
 */

public class Identidad {

    // Corregir esta funciÃ³n
    public static boolean esIdentidad_v1(int[][] matriz) {
        boolean identidad = true;

        for (int fila = 0; fila < matriz.length; fila++) { // No editar esta lÃ­nea
            for (int col = 0; col < matriz[fila].length; col++) { // No editar esta lÃ­nea

                if (fila == col) {
                    if (matriz[fila][col] != 1)
                        identidad = false;
                } else if (matriz[fila][col] != 0)
                    identidad = false;

            } // for
        } // for
        return identidad;
    }

    public static boolean esIdentidad_v2(int[][] matriz) {
        boolean identidad = true;
        int fila = 0;
        int columna = 0;

        while (identidad && fila < matriz.length && columna < matriz[fila].length) {
            if (fila == columna) {
                if (matriz[fila][columna] != 1)
                    identidad = false;
            } else if (matriz[fila][columna] != 0)
                identidad = false;

            ++columna;
            if (columna == matriz[fila].length) {
                columna = 0;
                ++fila;
            }
        }
        return identidad;
    }

    public static boolean esIdentidad_DyV(int[][] matriz) {
        boolean identidad = true;

        return DivideMatriz(matriz, 0, matriz.length - 1, identidad);
        // return identidad;
    }

    public static boolean DivideMatriz(int[][] matriz, int filaBase, int filaFinal, boolean identidad) {

        if (identidad) 
        {
            if (filaBase == filaFinal) {
                for (int columna = 0; columna < matriz[filaBase].length; columna++) {
                    if (columna == filaBase) {
                        if (matriz[filaBase][columna] != 1)
                            identidad = false;
                    } else if (matriz[filaBase][columna] != 0)
                        identidad = false;

                }
            } else {
                int filaMitad = (filaBase + filaFinal) / 2;
                identidad = DivideMatriz(matriz, filaBase, filaMitad, identidad) && DivideMatriz(matriz, filaMitad + 1, filaFinal, identidad);
            }
        }
        return identidad;

    }

    public static void main(String[] args) {

        int[][] m1 = { { 1, 0, 0, 0 }, { 0, 6, 0, 0 }, { 0, 0, 3, 0 }, { 0, 0, 0, 8 } };
        int[][] m2 = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
        int[][] m3 = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 0, 1 } };

        System.out.println("PRUEBA 1:");
        System.out.println(" * esIdentidad_v1 (m1): " + esIdentidad_v1(m1));
        System.out.println(" * esIdentidad_v1 (m2): " + esIdentidad_v1(m2));
        System.out.println(" * esIdentidad_v1 (m3): " + esIdentidad_v1(m3));

        System.out.println("\nPRUEBA 2:");
        System.out.println(" * esIdentidad_v2 (m1): " + esIdentidad_v2(m1));
        System.out.println(" * esIdentidad_v2 (m2): " + esIdentidad_v2(m2));
        System.out.println(" * esIdentidad_v2 (m3): " + esIdentidad_v2(m3));

        System.out.println("\nPRUEBA 3:");
        System.out.println(" * esIdentidad_DyV (m1): " + esIdentidad_DyV(m1));
        System.out.println(" * esIdentidad_DyV (m2): " + esIdentidad_DyV(m2));
        System.out.println(" * esIdentidad_DyV (m3): " + esIdentidad_DyV(m3));

        /* ****** DATOS PERSONALES ****** */

        String miNombre = "Marcos";
        String misApellidos = "Somoza Corral";
        String miExpediente = "21711787";

        System.out.println("\nESTUDIANTE:");
        System.out.println(" * Apellidos:\t" + miNombre);
        System.out.println(" * Nombre:\t" + misApellidos);
        System.out.println(" * Expediente:\t" + miExpediente);

        System.out.println("\n*** FIN ***");

    }// main

}// class
