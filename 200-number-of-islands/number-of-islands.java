class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int m= grid.length;
        int n= grid[0].length;
        boolean[][] vis= new boolean[m][n];
        int count=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    bfs(grid,vis, i, j);
                    count++;
                }
            }
        }
        return count;
        
    }
    
    public void bfs(char[][] grid, boolean[][] vis, int row, int col){
        int m= grid.length;
        int n= grid[0].length;
        int[][] directions= {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[] {row, col});
        vis[row][col]= true;
        
        while(!q.isEmpty()){
            int[] front = q.poll();
            int currRow= front[0];
            int currCol= front[1];
            
            for(int[] dir : directions){
                int newRow= currRow + dir[0];
                int newCol= currCol + dir[1];
                
                if(newRow >=0 && newCol >=0 && newRow<m && newCol<n && grid[newRow][newCol]=='1' && !vis[newRow][newCol]){
                    q.add(new int[] {newRow, newCol});
                    vis[newRow][newCol]=true;
                }
                
            }
        }
        
    }
}