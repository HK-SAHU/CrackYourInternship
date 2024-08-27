class NumArray {

    private int[] prefixSum;

    // Constructor to initialize the NumArray with the given nums array
    public NumArray(int[] nums) {
        // Create a prefix sum array of size nums.length + 1
        prefixSum = new int[nums.length + 1];

        // Compute prefix sums
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    // Method to return the sum of elements from index left to right
    public int sumRange(int left, int right) {
        // The sum from left to right is the difference between prefix sums
        return prefixSum[right + 1] - prefixSum[left];
    }

    // Main method for testing the implementation
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        
        System.out.println(numArray.sumRange(0, 2)); // Output: 1
        System.out.println(numArray.sumRange(2, 5)); // Output: -1
        System.out.println(numArray.sumRange(0, 5)); // Output: -3
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */