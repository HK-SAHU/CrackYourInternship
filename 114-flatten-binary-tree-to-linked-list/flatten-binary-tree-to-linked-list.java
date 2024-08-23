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
    public void flatten(TreeNode root) {
//         if (root == null) return;

//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
        
//         TreeNode prev = null;
        
//         while (!stack.isEmpty()) {
//             TreeNode node = stack.pop();
            
//             if (prev != null) {
//                 prev.left = null;
//                 prev.right = node;
//             }
            
//             if (node.right != null) {
//                 stack.push(node.right);
//             }
//             if (node.left != null) {
//                 stack.push(node.left);
//             }
            
//             prev = node;
//         }
        
        //Morris Traversal

        if(root==null)return;

        TreeNode current=root;

        while(current!=null){
            if(current.left!=null){
                TreeNode prev=current.left;

                while(prev.right!=null){
                    prev=prev.right;
                }
                prev.right=current.right;
                current.right=current.left;
                current.left=null;      //making left nodes null
            }
            current=current.right;
        }
        //another way of making left nodes null
        // current=root;
        // while(current!=null){
        //     current.left=null;
        //     current=current.right;
        // }
    }
}