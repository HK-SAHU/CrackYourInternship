//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    
    public static boolean isSafe(char[][] grid, int row, int col, boolean[][] visited){
        return (row>=0 && row< grid.length && col< grid[0].length && col>=0 && grid[row][col]=='1' && !visited[row][col]);
    }
    
    public static void DFS(char[][] grid, int i , int j, boolean[][] visited){
        int[] rowNeighbours={0,1,1,1,0,-1,-1,-1};
        int[] colNeighbours={1,1,0,-1,-1,-1,0,1};
        
        visited[i][j]= true;
        
        for( int k =0;k<8;k++){
            if(isSafe(grid, i+rowNeighbours[k] ,j+colNeighbours[k], visited)){
                DFS(grid, i+rowNeighbours[k] ,j+colNeighbours[k], visited);
            }
        }
    }
    
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited= new boolean[n][m];
        int count=0;
        
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    DFS(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
}