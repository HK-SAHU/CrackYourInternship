class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // Step 1: Create an adjacency list to represent the tree
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // Step 2: Arrays to store count and answer
        int[] count = new int[n];
        int[] answer = new int[n];

        // Step 3: Perform the initial DFS to calculate count and initial answer for node 0
        Arrays.fill(count, 1); // each node counts itself
        dfs(0, -1, tree, count, answer);

        // Step 4: Perform the second DFS to update the answer for all nodes based on the root
        dfs2(0, -1, tree, count, answer, n);

        return answer;
    }

    private void dfs(int node, int parent, List<List<Integer>> tree, int[] count, int[] answer) {
        for (int child : tree.get(node)) {
            if (child == parent) continue; // skip the parent node

            dfs(child, node, tree, count, answer);
            count[node] += count[child]; // update count for current node
            answer[0] += answer[child] + count[child]; // calculate the answer for root node (node 0)
        }
    }

    private void dfs2(int node, int parent, List<List<Integer>> tree, int[] count, int[] answer, int n) {
        for (int child : tree.get(node)) {
            if (child == parent) continue; // skip the parent node

            answer[child] = answer[node] - count[child] + (n - count[child]);
            dfs2(child, node, tree, count, answer, n);
        }
    }
    
}