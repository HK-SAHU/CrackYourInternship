//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}
// } Driver Code Ends



class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        Stack<Integer> s = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n + 1];

        // Initialize left and right arrays
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }

        // Fill elements of left[] using stack
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                left[i] = s.peek();
            }
            s.push(i);
        }

        // Clear the stack to be re-used
        while (!s.isEmpty()) {
            s.pop();
        }

        // Fill elements of right[] using stack
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                right[i] = s.peek();
            }
            s.push(i);
        }

        // Fill the answer array by comparing minimums
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }

        // Fill remaining entries
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        // Only return elements from 1 to n
        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            result[i - 1] = ans[i];
        }

        return result;
        
    }
}