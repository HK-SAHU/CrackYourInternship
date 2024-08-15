class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (dfs(i, color, graph)) {
                result.add(i);
            }
        }
        
        Collections.sort(result);
        return result;
    }
    
    private boolean dfs(int node, int[] color, int[][] graph) {
        // If node is already processed and safe
        if (color[node] == 2) {
            return true;
        }
        
        // If node is being processed (part of a cycle)
        if (color[node] == 1) {
            return false;
        }
        
        // Mark node as being processed
        color[node] = 1;
        
        // Check all neighbors
        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, color, graph)) {
                return false;
            }
        }
        
        // Mark node as safe
        color[node] = 2;
        return true;
    }
}