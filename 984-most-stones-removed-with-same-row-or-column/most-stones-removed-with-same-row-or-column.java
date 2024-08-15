class Solution {
    class UnionFind {
        int[] parent;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = n;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                count--;
            }
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        
        // Use a map to store the index of the first stone in each row and column
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int row = stones[i][0];
            int col = stones[i][1];

            // Union stones in the same row
            if (rowMap.containsKey(row)) {
                uf.union(i, rowMap.get(row));
            } else {
                rowMap.put(row, i);
            }

            // Union stones in the same column
            if (colMap.containsKey(col)) {
                uf.union(i, colMap.get(col));
            } else {
                colMap.put(col, i);
            }
        }

        return n - uf.count;
    }
}