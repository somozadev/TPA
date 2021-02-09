package test;

import javax.swing.DebugGraphics;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Matrices {

    /* SUSPENSO INMEDIATO > SUSPENDE EL BUCLE AL METER UN RETURN EN MITAD */
    public static boolean Find(int[][] matrix, int data) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                if (data == matrix[x][y])
                    return true;
            }
        }
        return false;
    }

    public static boolean FindRightTeacher(int[][]matrix, int data)
    {
        boolean finded = false;
        int row = 0; 
        int col = 0; 

        while(!finded && row < matrix.length)
        {
            while(!finded && col < matrix[row].length)
            {
                finded = (data == matrix[row][col]);

                System.out.println(matrix[row][col]);
                ++col;
            }
            col = 0;
            ++row;
        }
        return finded;
    }

    //UN SOLO WHILE... ES MAS O MENOS COSTOSO ?
    public static boolean FindRight(int[][] matrix, int data) {
        int row = 0;
        int col = 0;
        boolean finded = false;

        while (!finded && row < matrix.length && col < matrix[row].length) {  

            if (data == matrix[row][col])
                finded = true;

            ++col;

            if(col == matrix[row].length)
            {
                col = 0;
                ++row;
            }
        }

        return finded;
    }

    public static void main(String[] args) {
        int num = 0;
        int[][] matrix = { { 1, 2, 4, 6, 3 }, { 5, 7, 8, 0 } };
        System.out.println("Resultado: " + FindRightTeacher(matrix, num));

    }

}
