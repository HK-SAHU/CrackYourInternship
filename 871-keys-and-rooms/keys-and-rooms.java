class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean[] vis = new boolean[n+1];
        Queue<Integer> q= new LinkedList<>();
        
        q.add(0);
        vis[0]= true;
        int visitedRooms=0;
        
        while(!q.isEmpty()){
            int front=q.poll();
            visitedRooms++;
            
            for(int key: rooms.get(front)){
                if(!vis[key]){
                    q.add(key);
                    vis[key]= true;
                }
            }
        }
        return visitedRooms==n;
        
    }
    
}