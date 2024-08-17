class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int islandId = 2; // Start from 2 as 0 and 1 are already used in the grid
        Map<Integer, Integer> areaMap = new HashMap<>();

        // Step 1: Find all islands and their areas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, islandId);
                    areaMap.put(islandId, area);
                    islandId++;
                }
            }
        }

        int maxArea = areaMap.values().stream().max(Integer::compare).orElse(0);

        // Step 2: Try to change each 0 to 1 and calculate the possible maximum area
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    int newArea = 1; // Changing the 0 to 1

                    for (int[] direction : directions) {
                        int newRow = i + direction[0];
                        int newCol = j + direction[1];
                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] > 1) {
                            int id = grid[newRow][newCol];
                            if (uniqueIslands.add(id)) {
                                newArea += areaMap.get(id);
                            }
                        }
                    }

                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col, int islandId) {
        int n = grid.length;
        if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = islandId;
        int area = 1;

        for (int[] direction : directions) {
            area += dfs(grid, row + direction[0], col + direction[1], islandId);
        }

        return area;
    }
}