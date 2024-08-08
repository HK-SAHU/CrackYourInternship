class Solution {
    
    private int rows, cols;
    private int emptySquares = 1;  // Start with 1 to include the start square
    private int result = 0;
    
    
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        
        int startRow = 0, startCol = 0;
        
        // Find the starting point and count empty squares
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    startRow = r;
                    startCol = c;
                } else if (grid[r][c] == 0) {
                    emptySquares++;
                }
            }
        }
        
        // Backtrack from the starting point
        backtrack(grid, startRow, startCol, 0);
        return result;
    }
    
    private void backtrack(int[][] grid, int r, int c, int count) {
        // Boundary check or if it's an obstacle
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == -1) return;
        
        // If we reached the end square
        if (grid[r][c] == 2) {
            // Check if all squares are visited
            if (count == emptySquares) result++;
            return;
        }
        
        // Mark the square as visited
        grid[r][c] = -1;
        
        // Explore the 4 possible directions
        backtrack(grid, r + 1, c, count + 1);
        backtrack(grid, r - 1, c, count + 1);
        backtrack(grid, r, c + 1, count + 1);
        backtrack(grid, r, c - 1, count + 1);
        
        // Backtrack: Unmark the square
        grid[r][c] = 0;
    }
}