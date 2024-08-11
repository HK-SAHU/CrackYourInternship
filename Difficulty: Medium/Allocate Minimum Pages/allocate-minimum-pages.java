//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(n, a, m));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // If number of students is greater than number of books
        if (m > n) {
            return -1;
        }

        // Set low and high for binary search
        int low = Integer.MAX_VALUE;
        int high = 0;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, arr[i]);
            high += arr[i];
        }

        // Binary search to find the minimum feasible maximum pages
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If it is possible to allocate books with this maximum, move to lower half
            if (isFeasible(arr, n, m, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
    
    // Function to check if a given allocation is possible with the given maxPages
    private static boolean isFeasible(int[] arr, int n, int m, int maxPages) {
        int studentsRequired = 1;
        int currentPages = 0;

        for (int i = 0; i < n; i++) {
            // If the current book alone has more pages than maxPages, allocation isn't feasible
            if (arr[i] > maxPages) {
                return false;
            }

            // If adding this book exceeds maxPages, allocate to a new student
            if (currentPages + arr[i] > maxPages) {
                studentsRequired++;
                currentPages = arr[i];

                // If more students are required than available, return false
                if (studentsRequired > m) {
                    return false;
                }
            } else {
                currentPages += arr[i];
            }
        }

        return true;
    }
}