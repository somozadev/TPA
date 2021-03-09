package test;

public class BusquedaBinaria {
    
    public static int BinarySearch(int[] list, int target) {
        if (list.length == 0 || target > list[list.length - 1] || target < list[0])
            return -1;
        else
            return BinarySearchDnW(list, target, 0, list.length - 1);
    }

    public static int BinarySearchDnW(int[] list, int target, int start, int end) {
        if (start > end)
            return -1;
        else {
            int pos = (start + end) / 2;
            if (target == list[pos])
                return pos;
            else {
                if (target < list[pos])
                    return BinarySearchDnW(list, target, start, pos - 1);
                else
                    return BinarySearchDnW(list, target, pos + 1, end);
            }
        }
    }

    public static void main(String[] args) {

        int[] listaOrdenada = { 1, 2, 8, 9, 14, 33, 54, 78 };
        System.out.println("Resultado: " + BinarySearchDnW(listaOrdenada, 78, 0, listaOrdenada.length - 1));

    }
}
