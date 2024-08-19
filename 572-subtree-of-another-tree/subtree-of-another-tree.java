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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        
        // Check if the current trees are identical
        if (isSameTree(root, subRoot)) {
            return true;
        }
        
        // Recursively check left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        
        // Check left and right subtrees recursively
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
    
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         // Convert both trees to their string representations
//         String tree1 = preorder(root, true);
//         String tree2 = preorder(subRoot, true);
        
//         // Check if tree2 is a substring of tree1
//         return tree1.contains(tree2);
//     }
    
//     private String preorder(TreeNode node, boolean left) {
//         if (node == null) {
//             // Use a specific marker for nulls to avoid issues with nodes that have the same value
//             return left ? "lnull" : "rnull";
//         }
//         // Preorder traversal: root -> left -> right
//         return "#" + node.val + " " + preorder(node.left, true) + " " + preorder(node.right, false);
//     }
}