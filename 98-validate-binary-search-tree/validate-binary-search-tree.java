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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        // An empty tree is a valid BST
        if (node == null) {
            return true;
        }

        // Check the current node's value against the allowed range
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }

        // Recursively check the left subtree and right subtree
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}