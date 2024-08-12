//{ Driver Code Starts
import java.util.*;
import java.io.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int n)
    {
        // Step 1: Segregate positive and non-positive numbers
        int shift = segregate(arr, n);
        
        // Step 2: Use the positive portion of the array to find the missing number
        int missing = findMissingPositive(arr, n - shift, shift);
        return missing;
    }
    
    // Function to segregate positive and non-positive numbers
    static int segregate(int arr[], int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                // Move non-positive numbers to the left
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return j;  // Index from where positive numbers start
    }
    
    // Function to find the smallest positive missing number
    static int findMissingPositive(int arr[], int n, int shift) {
        // Marking indices corresponding to the presence of numbers
        for (int i = shift; i < n + shift; i++) {
            int val = Math.abs(arr[i]);
            if (val - 1 < n && arr[val - 1 + shift] > 0) {
                arr[val - 1 + shift] = -arr[val - 1 + shift];  // Mark the index as visited
            }
        }
        
        // Finding the first index with a positive value
        for (int i = shift; i < n + shift; i++) {
            if (arr[i] > 0) {
                return i + 1 - shift;
            }
        }
        
        // If all indices are marked, the missing number is n+1
        return n + 1;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) throws IOException
    {

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
        //taking testcases
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    
		    //input number n
			int n=Integer.parseInt(in.readLine().trim());
			int[] arr=new int[n];
			String s[]=in.readLine().trim().split(" ");
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			out.println(missing);
		}
		out.close();
    }
}


// } Driver Code Ends