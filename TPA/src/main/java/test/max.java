package test;

import java.util.concurrent.SubmissionPublisher;

import javax.swing.DebugGraphics;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class max {

    public static Result Divide(int[] lista) {

        int[] sublista1 = new int[lista.length / 2];
        int[] sublista2 = new int[lista.length / 2];

        for (int i = 0; i < sublista1.length; i++) {
            sublista1[i] = lista[i];
            System.out.println("1º:" + sublista1[i]);
        }
        for (int i = 0; i < sublista2.length; i++) {

            sublista2[i] = lista[i + sublista2.length];
            System.out.println("2º:" + sublista2[i]);
        }

        return new Result(sublista1, sublista2);
    }

    public static int MaxNum(int[] lista) {
        int resultadoIzq = 0, resultadoDer = 0;
        if (lista.length == 1)
            return lista[0];
        else {
            Result division = Divide(lista);
            resultadoIzq = MaxNum(division.sublista1);
            resultadoDer = MaxNum(division.sublista2);
            System.out.println("ResultadoIzq: " + resultadoIzq);
            System.out.println("ResultadoDer: " + resultadoDer);
        }

        return Math.max(resultadoIzq, resultadoDer);
    }

    public static void main(String[] args) {

        int[] lista = { 111, 2, 8, 6, 3, -2, 0, 5 };
        System.out.println("Resultado: " + MaxNum(lista));
        //2 * T (n) + 1 >>> Order N ((because n log n))

    }

}