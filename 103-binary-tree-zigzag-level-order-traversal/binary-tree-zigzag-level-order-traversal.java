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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // To store the final zigzag level order traversal
        if (root == null) {
            return result; // If the tree is empty, return an empty list
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Start with the root
        boolean leftToRight = true; // Flag to control the zigzag pattern
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // Dequeue the node
                
                if (leftToRight) {
                    level.add(node.val); // Left to right: Add normally
                } else {
                    level.add(0, node.val); // Right to left: Add to the beginning of the list
                }
                
                // Enqueue children
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            result.add(level); // Add the current level to the result
            leftToRight = !leftToRight; // Toggle the direction
        }
        
        return result; // Return the final zigzag level order traversal
    }
}