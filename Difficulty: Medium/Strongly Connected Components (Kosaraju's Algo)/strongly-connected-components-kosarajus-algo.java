//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    private void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }
        stack.push(v);
    }

    private void dfsReverse(int v, ArrayList<ArrayList<Integer>> transposeAdj, boolean[] visited) {
        visited[v] = true;
        for (int neighbor : transposeAdj.get(v)) {
            if (!visited[neighbor]) {
                dfsReverse(neighbor, transposeAdj, visited);
            }
        }
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        // Step 1: Perform DFS and store vertices in stack
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // Step 2: Create transpose of the graph
        ArrayList<ArrayList<Integer>> transposeAdj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            transposeAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                transposeAdj.get(neighbor).add(i);
            }
        }

        // Step 3: Perform DFS on transpose graph
        Arrays.fill(visited, false);
        int scc = 0;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                dfsReverse(v, transposeAdj, visited);
                scc++;
            }
        }

        return scc;
    }
}
