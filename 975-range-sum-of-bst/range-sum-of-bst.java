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
    public int rangeSumBST(TreeNode root, int low, int high) {
        // Base case: if the root is null, return 0
        if (root == null) {
            return 0;
        }
        
        // If the value of the root is greater than high, recurse to the left subtree
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        
        // If the value of the root is less than low, recurse to the right subtree
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        
        // If the value of the root is within [low, high], add it to the sum and recurse both subtrees
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}