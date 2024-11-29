class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source== destination) return true;
        boolean[] vis= new boolean[n];
        List<List<Integer>> adj= new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b= edges[i][1];
            adj.get(a).add(b);  // ath index pe jake b add kardo
            adj.get(b).add(a);
        }
        
        bfs(source, vis, adj, destination);
        return vis[destination];
        
        
    }
    
    public void bfs(int source, boolean[] vis, List<List<Integer>> adj, int end){
        Queue<Integer> q= new LinkedList<>();
        q.add(source);
        vis[source]=true;
        
        while(!q.isEmpty()){
            int front= q.poll();
            for(int ele : adj.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]= true;
                    if(ele==end) return;
                }
            }
        }
    }
}