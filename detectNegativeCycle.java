import java.util.Arrays;

class Graph {
    // Number of vertices in the graph
    private int V;
    // Number of edges in the graph
    private int E;
    // Array to store edges
    private Edge[] edges;

    // Edge class representing a directed edge with source, destination, and weight
    static class Edge {
        int src, dest, weight;
        Edge() {
            src = dest = weight = 0;
        }
    }

    // Graph constructor
    Graph(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[e];
        for (int i = 0; i < e; ++i) {
            edges[i] = new Edge();
        }
    }

    // Function to check if the graph contains a negative-weight cycle using Bellman-Ford
    void detectNegativeCycle(int src) {
        // Initialize distances from source to all other vertices as INFINITE
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int weight = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (int j = 0; j < E; ++j) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int weight = edges[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative-weight cycle");
                return;
            }
        }

        System.out.println("Graph does not contain negative-weight cycle");
    }

    public static void main(String[] args) {
        // Number of vertices and edges
        int V = 6;
        int E = 8;
        Graph graph = new Graph(V, E);

        // Define the edges with source, destination, and weight
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 5;

        graph.edges[1].src = 1;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 1;

        graph.edges[2].src = 1;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 2;

        graph.edges[3].src = 2;
        graph.edges[3].dest = 4;
        graph.edges[3].weight = 1;

        graph.edges[4].src = 4;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = -1;

        graph.edges[5].src = 3;
        graph.edges[5].dest = 5;
        graph.edges[5].weight = 2;

        graph.edges[6].src = 5;
        graph.edges[6].dest = 4;
        graph.edges[6].weight = -3;

        graph.edges[7].src = 4;
        graph.edges[7].dest = 3;
        graph.edges[7].weight = -1;

        // Detecting the negative cycle
        graph.detectNegativeCycle(0);
    }
}
