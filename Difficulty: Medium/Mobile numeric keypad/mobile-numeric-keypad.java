//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        if (n == 1) return 10;

        // Keypad layout
        int[][] moves = {
            {0, 8},    // 0
            {1, 2, 4}, // 1
            {2, 1, 3, 5}, // 2
            {3, 2, 6}, // 3
            {4, 1, 5, 7}, // 4
            {5, 2, 4, 6, 8}, // 5
            {6, 3, 5, 9}, // 6
            {7, 4, 8}, // 7
            {8, 0, 5, 7, 9}, // 8
            {9, 6, 8}  // 9
        };

        long[][] dp = new long[n + 1][10];

        // Initialize for sequences of length 1
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // Fill the dp array for sequences of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= 9; i++) {
                dp[len][i] = 0;
                for (int move : moves[i]) {
                    dp[len][i] += dp[len - 1][move];
                }
            }
        }

        // Sum up all sequences of length n
        long totalCount = 0;
        for (int i = 0; i <= 9; i++) {
            totalCount += dp[n][i];
        }

        return totalCount;
    }
}
