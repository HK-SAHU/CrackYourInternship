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
    public int pathSum(TreeNode root, int targetSum) {
        // HashMap to store (currentSum, number of ways to get this sum)
        HashMap<Long, Integer> map = new HashMap<>();
        // Initialize the map with (0, 1) to handle cases where a path's sum equals the targetSum
        map.put(0L, 1);
        return dfs(root, 0L, targetSum, map);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, HashMap<Long, Integer> map) {
        if (node == null) {
            return 0;
        }

        // Add the current node's value to the cumulative sum
        currSum += node.val;

        // Check how many times currSum - targetSum has appeared, which gives us the number of valid paths ending at this node
        int numPathsToCurr = map.getOrDefault(currSum - targetSum, 0);

        // Update the map with the current cumulative sum
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // Recursively search in the left and right subtrees
        int result = numPathsToCurr + dfs(node.left, currSum, targetSum, map) + dfs(node.right, currSum, targetSum, map);

        // After we are done with the current node, decrement the count of the current sum in the map
        map.put(currSum, map.get(currSum) - 1);

        return result;
    }
}