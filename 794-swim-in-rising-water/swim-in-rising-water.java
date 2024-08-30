class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];
        
        pq.offer(new int[]{grid[0][0], 0, 0}); // {max_elevation, row, col}
        visited[0][0] = true;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int maxElevation = current[0];
            int row = current[1];
            int col = current[2];
            
            if (row == n - 1 && col == n - 1) {
                return maxElevation;
            }
            
            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    int newMaxElevation = Math.max(maxElevation, grid[newRow][newCol]);
                    pq.offer(new int[]{newMaxElevation, newRow, newCol});
                }
            }
        }
        
        return -1; // This should never happen if the grid is valid
    }
}