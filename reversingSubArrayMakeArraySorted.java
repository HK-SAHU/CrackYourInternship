public class reversingSubArrayMakeArraySorted {

    // Function to check if reversing a subarray will sort the array
    static boolean checkReverse(int arr[], int n) {
        int start = -1, end = -1;

        // Find the first element which is out of order
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                start = i;
                break;
            }
        }

        // If the array is already sorted
        if (start == -1) {
            return true;
        }

        // Find the last element which is out of order
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                end = i;
                break;
            }
        }

        // Reverse the subarray from start to end
        reverse(arr, start, end);

        // Check if the array is sorted after reversing the subarray
        boolean isSorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }

        // Restore the original array if needed (optional)
        reverse(arr, start, end);

        return isSorted;
    }

    // Helper function to reverse the subarray
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Driver Program
    public static void main(String[] args) {
        int arr[] = {1, 2, 5, 4, 3};
        int n = arr.length;

        if (checkReverse(arr, n)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}
