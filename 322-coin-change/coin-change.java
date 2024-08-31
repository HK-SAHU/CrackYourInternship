class Solution {
    public int coinChange(int[] coins, int amount) {
        // Create an array to store the minimum number of coins needed for each amount
        int[] dp = new int[amount + 1];
        
        // Initialize the array with a value greater than the maximum possible number of coins
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins needed to make amount 0
        dp[0] = 0;
        
        // Iterate through all amounts from 1 to the target amount
        for (int i = 1; i <= amount; i++) {
            // For each coin denomination
            for (int coin : coins) {
                // If the coin value is less than or equal to the current amount
                if (coin <= i) {
                    // Update dp[i] with the minimum of its current value and 
                    // 1 (for the current coin) plus the number of coins needed for the remaining amount
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still greater than amount, it means we couldn't make up the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}