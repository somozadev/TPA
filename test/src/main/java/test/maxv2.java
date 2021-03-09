package test;

import javax.naming.ldap.StartTlsRequest;

public class maxv2 {

    public static int maximum(int[] array, int start, int end) {
        if (start == end)
            return array[start];

        else {
            int half = (start + end) / 2;
            int maxLeft = maximum(array, start, half);
            int maxRight = maximum(array, half + 1, end);
            return Math.max(maxLeft, maxRight);
        }
    }

    public static void main(String[] args) {

        int[] lista = { 111, 2, 8, 6, 3, -2, 0, 5 };
        System.out.println("Resultado: " + maximum(lista, 0, lista.length - 1));
        // 2 * T (n) + 1 >>> Order N ((because n log n))

    }

}
