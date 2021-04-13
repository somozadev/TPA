package test;

public class ArrEqualDyV {
    public static boolean AreEqual(int[] array1, int[] array2) {
        boolean areEqual = false;
        if (array1.length != array2.length)
            areEqual = false;
        else {
            areEqual = DnWAreEqual(array1, 0, array1.length - 1, array2);
        }

        return areEqual;
    }

    private static boolean DnWAreEqual(int[] array1, int start, int end, int[] array2) {
        boolean areEqual = false;

        if (start == end) {
            areEqual = array1[start] == array2[end];
        } else {
            int half = (start + end) / 2;
            areEqual = DnWAreEqual(array1, start, half, array2) && DnWAreEqual(array1, half + 1, end, array2);
        }
        return areEqual;
    }

    public static void main(String[] args) {

        int[] array1 = { 1, 7, 8, 89, 78, 8 };
        int[] array2 = { 1, 7, 8, 89, 78, 8 };
        System.out.println("Resultado: " + AreEqual(array1, array2));
    }

}