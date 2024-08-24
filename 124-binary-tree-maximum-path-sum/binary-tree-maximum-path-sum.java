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
    private int maxSum = Integer.MIN_VALUE; // Initialize maxSum with the smallest possible integer value
    
    public int maxPathSum(TreeNode root) {
        maxGain(root); // Start the DFS traversal
        return maxSum;
    }
    
    private int maxGain(TreeNode node) {
        if (node == null) return 0; // Base case: null node contributes 0 to the path sum
        
        // Recursively calculate the maximum gain from the left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        
        // Path sum including the current node and the highest gains from both sides
        int currentPathSum = node.val + leftGain + rightGain;
        
        // Update maxSum if the current path sum is greater than the previously recorded maxSum
        maxSum = Math.max(maxSum, currentPathSum);
        
        // Return the maximum gain that the current node can contribute to its parent
        return node.val + Math.max(leftGain, rightGain);
    }
}