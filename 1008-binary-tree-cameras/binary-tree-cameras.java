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
    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        // If the root is not covered, we need to place one more camera
        if (dfs(root) == 0) {
            cameras++;
        }
        return cameras;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 1; // A null node is considered covered without a camera
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == 0 || right == 0) {
            // If either child is not covered, place a camera here
            cameras++;
            return 2;
        }

        if (left == 2 || right == 2) {
            // If either child has a camera, this node is covered
            return 1;
        }

        // If both children are covered but have no cameras, this node is not covered
        return 0;
    }
}