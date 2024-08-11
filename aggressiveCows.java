import java.util.Arrays;
import java.util.Scanner;

public class aggressiveCows {

    // Function to check if we can place cows with at least minDist distance apart
    public static boolean canPlaceCows(int[] stalls, int n, int cows, int minDist) {
        int count = 1; // place the first cow in the first stall
        int lastPosition = stalls[0]; // position of the last placed cow

        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                count++; // place the next cow here
                lastPosition = stalls[i]; // update the position of the last placed cow
            }
            if (count == cows) {
                return true; // all cows placed successfully
            }
        }
        return false;
    }

    // Function to find the largest minimum distance
    public static int largestMinDist(int[] stalls, int n, int cows) {
        Arrays.sort(stalls); // Sort the stall positions

        int low = 1; // Minimum possible distance
        int high = stalls[n - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if we can place all cows with at least mid distance apart
            if (canPlaceCows(stalls, n, cows, mid)) {
                result = mid; // update result
                low = mid + 1; // try for a larger distance
            } else {
                high = mid - 1; // reduce the distance
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of stalls
            int c = sc.nextInt(); // Number of cows

            int[] stalls = new int[n];
            for (int i = 0; i < n; i++) {
                stalls[i] = sc.nextInt();
            }

            System.out.println(largestMinDist(stalls, n, c));
        }

        sc.close();
    }
}
