import java.util.Arrays;

public class SpanningTrees {

    // Function to calculate the determinant of a matrix
    private static int determinant(int[][] matrix, int n) {
        int det = 0;

        if (n == 1) {
            return matrix[0][0];
        }

        int[][] temp = new int[n][n];
        int sign = 1;

        for (int f = 0; f < n; f++) {
            getCofactor(matrix, temp, 0, f, n);
            det += sign * matrix[0][f] * determinant(temp, n - 1);
            sign = -sign;
        }

        return det;
    }

    // Function to get cofactor of a matrix
    private static void getCofactor(int[][] matrix, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = matrix[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    // Function to calculate the number of spanning trees using Kirchhoff's Theorem
    public static int numberOfSpanningTrees(int[][] graph) {
        int n = graph.length;
        int[][] laplacian = new int[n][n];

        // Create the Laplacian matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    laplacian[i][i] = Arrays.stream(graph[i]).sum();
                } else {
                    laplacian[i][j] = graph[i][j] == 1 ? -1 : 0;
                }
            }
        }

        // Remove the first row and first column to get the cofactor matrix
        int[][] cofactor = new int[n - 1][n - 1];
        getCofactor(laplacian, cofactor, 0, 0, n);

        // Return the determinant of the cofactor matrix
        return determinant(cofactor, n - 1);
    }

    public static void main(String[] args) {
        // Example graph adjacency matrix
        int[][] graph = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };

        System.out.println("The number of spanning trees is: " + numberOfSpanningTrees(graph));
    }
}
