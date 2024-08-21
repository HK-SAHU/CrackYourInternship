/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null, or root is one of p or q
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Search for p and q in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right are non-null, current node is the LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise, return the non-null value
        return left != null ? left : right;
    }
}