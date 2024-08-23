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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode construct(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }
        
        // The root is the first element in preorder
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // If there's only one node, return it
        if (preStart == preEnd) {
            return root;
        }
        
        // The next element in preorder is the root of the left subtree
        int leftRoot = preorder[preStart + 1];
        
        // Find the leftRoot in postorder to divide the postorder array
        int leftRootIndexInPost = -1;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == leftRoot) {
                leftRootIndexInPost = i;
                break;
            }
        }
        
        // Number of nodes in the left subtree
        int leftSubtreeSize = leftRootIndexInPost - postStart + 1;
        
        // Recursively construct the left and right subtrees
        root.left = construct(preorder, postorder, preStart + 1, preStart + leftSubtreeSize, postStart, leftRootIndexInPost);
        root.right = construct(preorder, postorder, preStart + leftSubtreeSize + 1, preEnd, leftRootIndexInPost + 1, postEnd - 1);
        
        return root;
    }
}