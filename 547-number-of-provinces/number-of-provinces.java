class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        boolean[] vis= new boolean[n+1];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                // bfs(i, isConnected, vis);
                dfs(i, isConnected, vis);
                count++;
            }
        }
        return count;
    }
    
    public void bfs(int i, int[][] adj, boolean[] vis){
        Queue<Integer> q= new LinkedList<>();
        q.add(i);
        vis[i]= true;
        while(!q.isEmpty()){
            int node= q.poll();
            for(int j=0; j<adj.length;j++){
                if(adj[node][j]==1 && !vis[j]){
                    q.add(j);
                    vis[j]= true;
                }
            }
        }
    }
    
    public void dfs(int i, int[][] adj, boolean[] vis){
        vis[i]= true;
        for(int j=0; j<adj.length;j++){
            if(adj[i][j]==1 && !vis[j]){
                dfs(j, adj, vis);   
            }
        }
    }
}