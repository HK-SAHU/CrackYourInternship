//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String str[] = read.readLine().trim().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
                
            Solution obj = new Solution();
            obj.radixSort(arr, n);
            for(int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
                
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    static void radixSort(int arr[], int n) 
    { 
        // Find the maximum number to determine the number of digits
        int max = getMax(arr, n);

        // Perform counting sort for every digit
        // The digit is represented by exp (10^i)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, n, exp);
        }
    } 
    
    // Function to get the maximum value in an array
    static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Function to perform counting sort on an array based on the digit represented by exp
    static void countingSort(int[] arr, int n, int exp) {
        int output[] = new int[n]; // Output array
        int count[] = new int[10]; // Count array for digits 0-9

        // Initialize count array with all zeros
        Arrays.fill(count, 0);

        // Store count of occurrences of digits in count[]
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so that it contains the position of this digit in the output array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the output array to arr[], so that arr[] now contains sorted numbers
        System.arraycopy(output, 0, arr, 0, n);
    }
}

