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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        
        // Traverse each vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) { // If the vertex is not visited, perform DFS
                if (isCyclicDFS(i, -1, visited, adj)) {
                    return true; // Cycle found
                }
            }
        }
        return false; // No cycle found
    }
    
    // Helper method for DFS
    private boolean isCyclicDFS(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true; // Mark the current node as visited
        
        // Explore all adjacent vertices
        for (Integer neighbor : adj.get(node)) {
            if (!visited[neighbor]) { // If the neighbor is not visited, do DFS on it
                if (isCyclicDFS(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) { // If the neighbor is visited and is not the parent of the current node
                return true; // Cycle detected
            }
        }
        return false;
    }
}