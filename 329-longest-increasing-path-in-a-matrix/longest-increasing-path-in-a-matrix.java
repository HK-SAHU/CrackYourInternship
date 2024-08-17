class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows][cols]; // Memoization table

        int maxPath = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int maxLength = 1; // At least the cell itself is part of the path
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
                    && matrix[newRow][newCol] > matrix[row][col]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, newRow, newCol, memo));
            }
        }

        memo[row][col] = maxLength;
        return maxLength;
    }
}