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
    // Map to store parent pointers
    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || target == null || k < 0) return result;
        
        // Step 1: Populate the parentMap
        buildParentMap(root, null);
        
        // Step 2: BFS from the target node
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        queue.add(target);
        visited.add(target);
        int currentDistance = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentDistance == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }
            currentDistance++;
            
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                
                // Explore neighbors: left, right, and parent
                if (currentNode.left != null && !visited.contains(currentNode.left)) {
                    visited.add(currentNode.left);
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null && !visited.contains(currentNode.right)) {
                    visited.add(currentNode.right);
                    queue.add(currentNode.right);
                }
                TreeNode parent = parentMap.get(currentNode);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.add(parent);
                }
            }
        }
        
        return result;
    }
    
    // Helper method to build the parent map
    private void buildParentMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        parentMap.put(node, parent);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }
}