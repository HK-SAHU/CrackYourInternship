//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        
        // Check for cycle starting from each unvisited vertex
        for (int i = 0; i < V; i++) {
            if (dfs(i, visited, recStack, adj)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(int v, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj) {
        // If vertex is already in recursion stack, cycle found
        if (recStack[v]) {
            return true;
        }
        
        // If vertex is already visited and not in recursion stack, no cycle here
        if (visited[v]) {
            return false;
        }
        
        // Mark the current node as visited and part of recursion stack
        visited[v] = true;
        recStack[v] = true;
        
        // Check all adjacent vertices
        for (Integer neighbor : adj.get(v)) {
            if (dfs(neighbor, visited, recStack, adj)) {
                return true;
            }
        }
        
        // Remove the vertex from recursion stack
        recStack[v] = false;
        
        return false;
    }
}