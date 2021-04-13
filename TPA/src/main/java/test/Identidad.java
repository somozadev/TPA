package test;

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

                if (identidad) 
                {
                    if (fila == col)
                        if (matriz[fila][col] == 1)
                            identidad = true;
                        else
                            identidad = false;
                    else if (matriz[fila][col] == 0)
                        identidad = true;
                    else
                        identidad = false;
                }

                /* 
                * SOLUCION CON RETURNS ADICIONALES
                
                    if (fila == col)
                        if (matriz[fila][col] == 1)
                            identidad = true;
                        else
                            return identidad = false;
                    else if (matriz[fila][col] == 0)
                        identidad = true;
                    else
                        return identidad = false;
                *
                */

            } // for
        } // for
        return identidad;
    }

    public static boolean esIdentidad_v2(int[][] matriz) {
        // Completar
        return true; // sentencia insertara para poder compilar
    }

    public static boolean esIdentidad_DyV(int[][] matriz) {
        // Completar
        return true; // sentencia insertara para poder compilar
    }

    public static void main(String[] args) {

        int[][] m3 = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 0, 1 } };

        int[][] m1 = { { 1, 0, 0, 0 }, { 0, 6, 0, 0 }, { 0, 0, 3, 0 }, { 0, 0, 0, 8 } };

        int[][] m2 = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };

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
