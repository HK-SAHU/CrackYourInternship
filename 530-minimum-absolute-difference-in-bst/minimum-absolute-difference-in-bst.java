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
    
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;
    
    
    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }
    
    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        // Traverse the left subtree
        inOrderTraversal(node.left);
        
        // Process the current node
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        
        // Traverse the right subtree
        inOrderTraversal(node.right);
    }
}