public class FindPositie {
    public static int FindHalfPosDnW(int[] array, int start, int end) { // T(N) pertenece a 0 = log 2 n
        int half = (start + end) / 2;
        if (array[half] > 0) {
            if (array[half - 1] < 0)

                return array.length - half;
            else
                return FindHalfPosDnW(array, start, half - 1);
        } else {
            if (array[half + 1] > 0)
                return array.length - 1 - half;
            else
                return FindHalfPosDnW(array, half + 1, end);
        }
    }
}
