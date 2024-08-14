//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V]; // Array to track visited vertices
        ArrayList<Integer> dfsTraversal = new ArrayList<>(); // List to store the DFS traversal
        
        // Start DFS from vertex 0
        dfs(0, adj, visited, dfsTraversal);
        
        return dfsTraversal;
    }
    
    // Recursive DFS function
    private void dfs(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, List<Integer> dfsTraversal) {
        // Mark the current vertex as visited
        visited[vertex] = true;
        // Add the vertex to the DFS traversal list
        dfsTraversal.add(vertex);
        
        // Recur for all adjacent vertices
        for (int neighbor : adj.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, dfsTraversal);
            }
        }
    }
}