//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public boolean isPossible(int k, int[] arr1, int[] arr2) {
        int n = arr1.length;

        // Sort arr1[] in increasing order
        Arrays.sort(arr1);

        // Sort arr2[] in increasing order
        Arrays.sort(arr2);

        // Check the sum of corresponding elements with arr2 in reverse
        for (int i = 0; i < n; i++) {
            if (arr1[i] + arr2[n - 1 - i] < k) {
                return false;
            }
        }

        return true;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            String[] arr1Str = sc.nextLine().split(" ");
            String[] arr2Str = sc.nextLine().split(" ");

            int[] arr1 = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int[] arr2 = Arrays.stream(arr2Str).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            boolean result = solution.isPossible(k, arr1, arr2);

            if (result) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
        sc.close();
    }
}
// } Driver Code Ends