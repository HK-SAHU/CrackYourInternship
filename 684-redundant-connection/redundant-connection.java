class Solution {
    // Union-Find helper class
    class UnionFind {
        private int[] parent;
        private int[] rank;

        // Constructor: initializes union-find structure
        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // Find with path compression
        public int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]); // path compression
            }
            return parent[u];
        }

        // Union by rank
        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) {
                return false; // u and v are already in the same set, so this edge forms a cycle
            }
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1); // nodes are labeled from 1 to n
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!uf.union(u, v)) {
                return edge; // this edge forms a cycle
            }
        }
        
        return new int[0]; // should not reach here
    }
}