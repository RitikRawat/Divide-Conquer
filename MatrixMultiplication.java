

import java.util.Arrays;

public class MatrixMultiplication {
    static void divide(int A[][], int a[][], int b[][], int c[][], int d[][]) {
        int n = A.length;
        for (int i = 0; i < n / 2; i++) {
            int j = 0;
            for (j = 0; j < n / 2; j++) {
                a[i][j] = A[i][j];
            }
            for (; j < n; j++) {
                b[i][j - n / 2] = A[i][j];
            }
        }
        for (int i = n / 2; i < n; i++) {
            int j = 0;
            for (j = 0; j < n / 2; j++) {
                c[i - n / 2][j] = A[i][j];
            }
            for (; j < n; j++) {
                d[i - n / 2][j - n / 2] = A[i][j];
            }
        }

    }

    private static int[][] pad(int[][] A) {
        int n = A.length;

        int[][] r = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                r[i][j] = A[i][j];
        }
        return r;

    }

    static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = B.length;

        if (n != m) {
            System.out.println("Enter same length array");
            System.exit(0);
        }

        if (n > 1 && n % 2 != 0) {
            A = pad(A);
            B = pad(B);

        }
        n = A.length;
        int[][] A11 = new int[n / 2][n / 2];
        int[][] A12 = new int[n / 2][n / 2];
        int[][] A21 = new int[n / 2][n / 2];
        int[][] A22 = new int[n / 2][n / 2];
        int[][] B11 = new int[n / 2][n / 2];
        int[][] B12 = new int[n / 2][n / 2];
        int[][] B21 = new int[n / 2][n / 2];
        int[][] B22 = new int[n / 2][n / 2];
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }

        divide(A, A11, A12, A21, A22);
        divide(B, B11, B12, B21, B22);


        sumMatrix(C, multiply(A11, B11), multiply(A12, B21),0,0);
        sumMatrix(C, multiply(A11, B12), multiply(A12, B22),0,n/2);
        sumMatrix(C, multiply(A21, B11), multiply(A22, B21),n/2,0);
        sumMatrix(C, multiply(A21, B12), multiply(A22, B22),n/2,n/2);





        return C;

    }

    private static void sumMatrix(int[][] C, int[][] A, int[][] B, int rowC, int colC) {
        int n = C.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++)
                C[i + rowC][j + colC] = A[i][j] + B[i][j];
        }
    }



    public static void printM(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(A[i][j]);

            System.out.println();
        }
        System.out.println();

    }
}

