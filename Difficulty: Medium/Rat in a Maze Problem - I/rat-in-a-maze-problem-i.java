//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        int n= mat.length;
        ArrayList<String> paths = new ArrayList<>();
        if (mat[0][0] == 0 || mat[n-1][n-1] == 0) {
            return paths; // No paths possible if start or end is blocked
        }
        
        boolean[][] visited = new boolean[n][n];
        dfs(mat, n, 0, 0, "", visited, paths);
        return paths;
    }
    
    private static void dfs(int[][] mat, int n, int row, int col, String path, boolean[][] visited, List<String> paths) {
        // Base case: If we reach the bottom-right corner, add the path to the list
        if (row == n - 1 && col == n - 1) {
            paths.add(path);
            return;
        }
        
        // Mark the current cell as visited
        visited[row][col] = true;
        
        // Explore all four directions
        
        // Move Down
        if (row + 1 < n && mat[row + 1][col] == 1 && !visited[row + 1][col]) {
            dfs(mat, n, row + 1, col, path + 'D', visited, paths);
        }
        
        // Move Right
        if (col + 1 < n && mat[row][col + 1] == 1 && !visited[row][col + 1]) {
            dfs(mat, n, row, col + 1, path + 'R', visited, paths);
        }
        
        // Move Up
        if (row - 1 >= 0 && mat[row - 1][col] == 1 && !visited[row - 1][col]) {
            dfs(mat, n, row - 1, col, path + 'U', visited, paths);
        }
        
        // Move Left
        if (col - 1 >= 0 && mat[row][col - 1] == 1 && !visited[row][col - 1]) {
            dfs(mat, n, row, col - 1, path + 'L', visited, paths);
        }
        
        // Backtrack: Mark the cell as unvisited for other paths
        visited[row][col] = false;
    }
}