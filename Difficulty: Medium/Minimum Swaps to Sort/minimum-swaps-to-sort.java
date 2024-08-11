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
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    
    // Helper class to store pairs of value and original index
    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int n = nums.length;

        // Create a pair of (value, original index)
        List<Pair> arrPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrPos.add(new Pair(nums[i], i));
        }

        // Sort the array by values to find where each element should go
        arrPos.sort(Comparator.comparingInt(pair -> pair.value));

        // To keep track of visited elements
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int swaps = 0;

        // Traverse the array and count cycles
        for (int i = 0; i < n; i++) {
            // If already visited or already in the correct position, skip
            if (visited[i] || arrPos.get(i).index == i) {
                continue;
            }

            // Find the cycle starting at element i
            int cycleLength = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;

                // Move to the index where the current element should be
                j = arrPos.get(j).index;
                cycleLength++;
            }

            // If there is a cycle of length > 1, then (cycle length - 1) swaps are needed
            if (cycleLength > 1) {
                swaps += (cycleLength - 1);
            }
        }

        return swaps;
    }
}