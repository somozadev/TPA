package test;

public class MatrixSumDyV {


    /*
    * T(N) = donde N es == al numero de filas, del cual depende la complejidad 
    * caso base = N
    * caso gral = a * T(n/b) + c n^k ==> 2 * T(N/2) + 1 (((+1 por el rowmid+1?)))
    * como hay 2 llamadas a matrixsum ==> a = 2
    * b = 2 
    * k = 0
    * sol = T(N) pertenece a O(n^ log base b de a = log base 2 de 2 = 1 ). En realidad es de orden n^2 dado que estamos haciendo como hariamos con 
    * un doble for, aunque estemos usando solo uno.
    */
    public static void MatrixSum(int[][] a, int[][] b, int rowStart, int rowEnd, int[][] res) {
        // caso base, 1 sola fila
        if (rowStart == rowEnd) {

            for (int col = 0; col < 0; col++) 
                res[rowStart][col] = a[rowStart][col] + b[rowStart][col];
            
        } 
        //caso gral
        else {

            int rowMid = (rowStart + rowEnd) / 2;
            MatrixSum(a, b, rowStart, rowMid, res);
            MatrixSum(a, b, rowMid + 1, rowEnd, res);
        }

    }

}