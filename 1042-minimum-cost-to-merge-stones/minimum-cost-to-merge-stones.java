class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;

        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }

        int[][][] dp = new int[n][n][k + 1];
        for (int len = k; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                for (int m = 2; m <= k; m++) {
                    dp[i][j][m] = Integer.MAX_VALUE;
                    for (int p = i; p < j; p += k - 1) {
                        dp[i][j][m] = Math.min(dp[i][j][m], dp[i][p][1] + dp[p + 1][j][m - 1]);
                    }
                }
                dp[i][j][1] = dp[i][j][k] + prefixSum[j + 1] - prefixSum[i];
            }
        }

        return dp[0][n - 1][1];
    }
}