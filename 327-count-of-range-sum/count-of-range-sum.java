class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Compute prefix sums
        long[] prefixSums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        // Use merge sort to count the number of valid range sums
        return mergeSort(prefixSums, 0, prefixSums.length - 1, lower, upper);
    }

    private int mergeSort(long[] prefixSums, int left, int right, int lower, int upper) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = mergeSort(prefixSums, left, mid, lower, upper) 
                    + mergeSort(prefixSums, mid + 1, right, lower, upper);

        // Count valid range sums in the merge step
        int j = mid + 1, k = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (k <= right && prefixSums[k] - prefixSums[i] < lower) {
                k++;
            }
            while (j <= right && prefixSums[j] - prefixSums[i] <= upper) {
                j++;
            }
            count += j - k;
        }

        // Merge the two sorted halves
        merge(prefixSums, left, mid, right);
        return count;
    }

    private void merge(long[] prefixSums, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, t = 0;

        while (i <= mid && j <= right) {
            if (prefixSums[i] <= prefixSums[j]) {
                temp[t++] = prefixSums[i++];
            } else {
                temp[t++] = prefixSums[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = prefixSums[i++];
        }

        while (j <= right) {
            temp[t++] = prefixSums[j++];
        }

        for (i = left; i <= right; i++) {
            prefixSums[i] = temp[i - left];
        }
    }
}