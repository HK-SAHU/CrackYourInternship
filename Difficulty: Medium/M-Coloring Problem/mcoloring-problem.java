//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be colored with at most M colors such
    // that no two adjacent vertices of graph are colored with same color.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Array to store colors assigned to all vertices
        int[] colors = new int[n];
        
        // Initialize all colors as 0 (meaning no color)
        for (int i = 0; i < n; i++) {
            colors[i] = 0;
        }
        
        // Start solving the problem using backtracking
        if (solveGraph(graph, colors, m, 0, n)) {
            return true;  // If solution exists
        }
        
        return false;  // If no solution exists
    }
    
    // Utility function to solve the problem using backtracking
    private boolean solveGraph(boolean[][] graph, int[] colors, int m, int vertex, int n) {
        // Base case: If all vertices are assigned a color return true
        if (vertex == n) {
            return true;
        }
        
        // Try different colors for the current vertex
        for (int color = 1; color <= m; color++) {
            // Check if assignment of this color to vertex is safe
            if (isSafe(graph, colors, vertex, color, n)) {
                // Assign color to the vertex
                colors[vertex] = color;
                
                // Recur to assign colors to the rest of the vertices
                if (solveGraph(graph, colors, m, vertex + 1, n)) {
                    return true;
                }
                
                // If assigning color doesn't lead to a solution, remove it (backtrack)
                colors[vertex] = 0;
            }
        }
        
        // If no color can be assigned to this vertex, return false
        return false;
    }
    
    // Utility function to check if it is safe to color vertex with a given color
    private boolean isSafe(boolean[][] graph, int[] colors, int vertex, int color, int n) {
        // Check for all adjacent vertices
        for (int i = 0; i < n; i++) {
            // If there is an edge between vertex and i and the color is the same
            if (graph[vertex][i] && colors[i] == color) {
                return false;
            }
        }
        return true;
    }
}