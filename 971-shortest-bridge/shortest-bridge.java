class Solution {
    private int n;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        boolean found = false;
        
        // Step 1: Find a cell of the first island using DFS
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue, visited);
                    found = true;
                }
            }
        }
        
        // Step 2: Use BFS to expand from the first island
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : directions) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            return steps;
                        }
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            steps++;
        }
        
        return -1; // This should never happen if the input is valid
    }
    
    private void dfs(int[][] grid, int i, int j, Queue<int[]> queue, boolean[][] visited) {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1], queue, visited);
        }
    }
}