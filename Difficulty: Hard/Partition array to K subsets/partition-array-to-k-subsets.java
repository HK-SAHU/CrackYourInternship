//{ Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
    public boolean isKPartitionPossible(int[] a, int n, int k) {
        // Calculate total sum of the array
        int totalSum = 0;
        for (int num : a) {
            totalSum += num;
        }
        
        // If total sum is not divisible by K, return false
        if (totalSum % k != 0) {
            return false;
        }
        
        int subsetSum = totalSum / k;
        boolean[] visited = new boolean[n];
        
        // Start backtracking
        return canPartition(0, 0, 0, k, subsetSum, visited, a);
    }
    
    private boolean canPartition(int startIndex, int currentSum, int currentNum, int k, int subsetSum, boolean[] visited, int[] a) {
        // If we have filled k-1 subsets, we can be sure that the last subset will also have the correct sum
        if (k == 1) {
            return true;
        }
        
        // If current subset sum is equal to required subset sum, start the next subset
        if (currentSum == subsetSum && currentNum > 0) {
            return canPartition(0, 0, 0, k - 1, subsetSum, visited, a);
        }
        
        // Try to add each element into current subset
        for (int i = startIndex; i < a.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                // Try adding this element to the current subset
                if (canPartition(i + 1, currentSum + a[i], currentNum + 1, k, subsetSum, visited, a)) {
                    return true;
                }
                
                // Backtrack
                visited[i] = false;
            }
        }
        
        return false;
    }
}
