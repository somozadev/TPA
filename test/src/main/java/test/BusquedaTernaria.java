package test;

public class BusquedaTernaria {
    public static int TernarySearch(int[] list, int target) {
        if (list.length == 0 || target > list[list.length - 1] || target < list[0])
            return -1;
        else
            return TernarySearchDnW(list, target, 0, list.length - 1);
    }

    public static int TernarySearchDnW(int[] list, int target, int start, int end) {
        if (start > end)
            return -1;
        else {
            int mid1 = start + (end - start) / 3;
            int mid2 = start + 2 * (end - start) / 3;

            if (target == list[mid1])
                return mid1;
            if (target == list[mid2])
                return mid2;

            if (target < list[mid1])
                return TernarySearchDnW(list, target, start, mid1 - 1);
            else if (target > list[mid2])
                return TernarySearchDnW(list, target, mid2 + 1, end);
            else
                return TernarySearchDnW(list, target, mid1 + 1, mid2 - 1);
        }
    }

    public static void main(String[] args) {

        int[] listaOrdenada = { 1, 2, 8, 9, 14, 33, 54, 78 };
        System.out.println("Resultado: " + TernarySearch(listaOrdenada,  78));

    }
}
