//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        int n = nums.length;
        // Initialize the memoization array with -1 indicating uncalculated subproblems
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return wordWrap(nums, k, 0, memo);
        
    }
    
    // Recursive function with memoization to find the minimum cost of word wrap
    private int wordWrap(int[] nums, int k, int index, int[] memo) {
        int n = nums.length;

        // If we have reached the end of the words, no cost is incurred
        if (index == n) {
            return 0;
        }

        // If this subproblem has already been solved, return the stored result
        if (memo[index] != -1) {
            return memo[index];
        }

        int minCost = Integer.MAX_VALUE;
        int currentLength = 0;

        // Try to place words from the current index to j in one line
        for (int j = index; j < n; j++) {
            currentLength += nums[j];

            // If the current line exceeds the maximum width, break the loop
            if (currentLength > k) {
                break;
            }

            int extraSpaces = k - currentLength;
            int cost = (j == n - 1) ? 0 : extraSpaces * extraSpaces;

            // Calculate the total cost for the current arrangement
            cost += wordWrap(nums, k, j + 1, memo);

            // Update the minimum cost
            minCost = Math.min(minCost, cost);

            // Account for the space between words
            currentLength++;
        }

        // Store the result in the memoization array
        memo[index] = minCost;
        return minCost;
    }
    
    
} 