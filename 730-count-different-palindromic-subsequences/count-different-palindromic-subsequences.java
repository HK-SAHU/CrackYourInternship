class Solution {
    public int countPalindromicSubsequences(String s) {
        int MOD = 1000000007;
        int n = s.length();
        int[][] dp = new int[n][n];
        int[] next = new int[n];
        int[] prev = new int[n];
        int[] last = new int[4];
        
        for (int i = 0; i < 4; i++) last[i] = -1;
        for (int i = 0; i < n; i++) {
            prev[i] = last[s.charAt(i) - 'a'];
            last[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < 4; i++) last[i] = n;
        for (int i = n - 1; i >= 0; i--) {
            next[i] = last[s.charAt(i) - 'a'];
            last[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    int low = next[i];
                    int high = prev[j];
                    if (low > high) {
                        dp[i][j] = (dp[i + 1][j - 1] * 2 + 2) % MOD;
                    } else if (low == high) {
                        dp[i][j] = (dp[i + 1][j - 1] * 2 + 1) % MOD;
                    } else {
                        dp[i][j] = (dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1]) % MOD;
                    }
                } else {
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1]) % MOD;
                }
                if (dp[i][j] < 0) dp[i][j] += MOD;
            }
        }
        
        return dp[0][n - 1];
    }
}