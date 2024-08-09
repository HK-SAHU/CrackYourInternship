//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}
// } Driver Code Ends


class Solution
{
    
    private static String max;
    
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
    {
        max = str;  // Initialize max with the original number
        findMaxHelper(str.toCharArray(), k);
        return max;   
    }
    
    private static void findMaxHelper(char[] num, int k) {
        if (k == 0) return;

        int n = num.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (num[i] < num[j]) {  // Try to maximize the number
                    // Swap num[i] and num[j]
                    swap(num, i, j);

                    // If the new number is greater than the max number, update max
                    String currentNum = new String(num);
                    if (max.compareTo(currentNum) < 0) {
                        max = currentNum;
                    }

                    // Recurse with one less swap available
                    findMaxHelper(num, k - 1);

                    // Backtrack (swap back)
                    swap(num, i, j);
                }
            }
        }
    }
    
    private static void swap(char[] num, int i, int j) {
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    
}