//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    // Function to find the length of the longest subarray with sum 0
    int maxLen(int arr[], int n) {
        // HashMap to store the cumulative sum and its earliest occurrence
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;  // To store the maximum length of subarray with sum 0
        int sum = 0;  // To store the cumulative sum

        for (int i = 0; i < n; i++) {
            sum += arr[i];  // Update cumulative sum

            // If the cumulative sum is 0, update maxLength to the current index + 1
            if (sum == 0) {
                maxLength = i + 1;
            } 
            // If the cumulative sum has been seen before
            if (map.containsKey(sum)) {
                // Update maxLength to the maximum of the current maxLength and the length of the subarray
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                // Store the first occurrence of the cumulative sum
                map.put(sum, i);
            }
        }
        return maxLength;  // Return the maximum length found
    }
}