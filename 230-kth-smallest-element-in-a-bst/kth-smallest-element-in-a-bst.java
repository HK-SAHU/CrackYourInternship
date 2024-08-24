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
    private int count = 0; // To keep track of the number of nodes visited
    private int result = 0; // To store the result (kth smallest element)
    
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k); // Start in-order traversal
        return result; // Return the kth smallest element
    }
    
    private void inorder(TreeNode node, int k) {
        if (node == null) {
            return; // Base case: if the node is null, return
        }
        
        inorder(node.left, k); // Visit left subtree
        
        // Process current node
        count++; // Increment the count of nodes visited
        if (count == k) {
            result = node.val; // If count equals k, we found the kth smallest
            return;
        }
        
        inorder(node.right, k); // Visit right subtree
    }
}