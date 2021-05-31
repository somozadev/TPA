package test;

import javax.print.attribute.standard.Media;
import javax.swing.table.AbstractTableModel;

public class MediaDyV {

    public static float Media(int[] array) {
        float media = 0;
        if (array.length % 2 != 0)
            media = -1;
        else
            media = MediaDnW(array, 0, array.length - 1, 0) / array.length;

        return media;

    }

    public static float MediaDnW(int[] array, int start, int end, float media) {

        if (start == end) {
            media += array[start];
        } else {
            int mid = (start + end) / 2;
            media = MediaDnW(array, start, mid, media) + MediaDnW(array, mid + 1, end, media);
        }
        return media;
    }

    public static float MediaIterativa(int[] array) {
        float media = 0;
        for (int i = 0; i < array.length; i++) {
            media += array[i];
        }
        return media / array.length;
    }


    public static void main(String[] args) {

        int[] prueba = { 3, 3, 3, 3, 2, 2, 2, 2 };

        System.out.println("MEDIA DIVIDE Y VENCERAS:");
        System.out.println(Media(prueba));
        System.out.println("MEDIA ITERATIVA:");
        System.out.println(MediaIterativa(prueba));
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
}
