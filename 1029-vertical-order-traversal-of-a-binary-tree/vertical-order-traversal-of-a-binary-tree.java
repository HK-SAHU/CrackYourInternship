/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Step 1: Create a TreeMap to store nodes by column indices
        TreeMap<Integer, PriorityQueue<int[]>> columnTable = new TreeMap<>();

        // Step 2: Perform DFS to populate the columnTable
        dfs(root, 0, 0, columnTable);

        // Step 3: Build the result from the columnTable
        List<List<Integer>> result = new ArrayList<>();
        for (PriorityQueue<int[]> nodes : columnTable.values()) {
            List<Integer> column = new ArrayList<>();
            while (!nodes.isEmpty()) {
                column.add(nodes.poll()[1]);
            }
            result.add(column);
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col, TreeMap<Integer, PriorityQueue<int[]>> columnTable) {
        if (node == null) {
            return;
        }

        // Step 2a: Add the current node to the columnTable
        columnTable.putIfAbsent(col, new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        columnTable.get(col).add(new int[]{row, node.val});

        // Step 2b: Traverse the left and right children
        dfs(node.left, row + 1, col - 1, columnTable);
        dfs(node.right, row + 1, col + 1, columnTable);
    }
}