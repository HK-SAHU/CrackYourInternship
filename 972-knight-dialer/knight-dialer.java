class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int[][] MOVES = {
        {4, 6},     // 0
        {6, 8},     // 1
        {7, 9},     // 2
        {4, 8},     // 3
        {0, 3, 9},  // 4
        {},         // 5
        {0, 1, 7},  // 6
        {2, 6},     // 7
        {1, 3},     // 8
        {2, 4}      // 9
    };

    public int knightDialer(int n) {
        long[] dp = new long[10];
        Arrays.fill(dp, 1);
        
        for (int jump = 1; jump < n; jump++) {
            long[] newDp = new long[10];
            for (int digit = 0; digit < 10; digit++) {
                for (int nextDigit : MOVES[digit]) {
                    newDp[nextDigit] = (newDp[nextDigit] + dp[digit]) % MOD;
                }
            }
            dp = newDp;
        }
        
        long total = 0;
        for (long count : dp) {
            total = (total + count) % MOD;
        }
        
        return (int) total;
    }
}