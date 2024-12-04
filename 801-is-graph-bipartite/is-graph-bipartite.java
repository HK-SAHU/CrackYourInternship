class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1); // Initialize all nodes with no color (-1)

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) { // If the node is unvisited
                if (!bfs(i, graph, colors)) { // If any component is not bipartite
                    return false;
                }
            }
        }
        return true; // All components are bipartite
    }

    private boolean bfs(int start, int[][] graph, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 0; // Start with color 0

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph[node]) { // Iterate over neighbors of the node
                if (colors[neighbor] == -1) {
                    // Assign opposite color to the neighbor
                    colors[neighbor] = 1 - colors[node];
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[node]) {
                    // If a neighbor has the same color as the current node, it's not bipartite
                    return false;
                }
            }
        }
        return true; // This component is bipartite
    }
}
