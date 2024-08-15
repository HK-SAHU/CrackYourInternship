class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Create an adjacency list to represent the tree structure
        List<List<Integer>> subordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            subordinates.add(new ArrayList<>());
        }
        
        // Build the tree structure
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                subordinates.get(manager[i]).add(i);
            }
        }
        
        // Perform DFS starting from the head
        return dfs(headID, subordinates, informTime);
    }
    
    private int dfs(int employee, List<List<Integer>> subordinates, int[] informTime) {
        int maxTime = 0;
        
        // Recursively calculate the time for each subordinate
        for (int subordinate : subordinates.get(employee)) {
            maxTime = Math.max(maxTime, dfs(subordinate, subordinates, informTime));
        }
        
        // Return the time to inform this employee plus the max time of its subordinates
        return informTime[employee] + maxTime;
    }
}