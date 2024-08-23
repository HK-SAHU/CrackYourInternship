class Solution {
    public int numTrees(int n) {
        // Create an array to store the number of unique BSTs for each number of nodes
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // There is exactly one BST with 0 nodes (an empty tree)
        dp[1] = 1; // There is exactly one BST with 1 node
        
        // Fill the dp array using the dynamic programming formula
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        
        return dp[n];
    }
}