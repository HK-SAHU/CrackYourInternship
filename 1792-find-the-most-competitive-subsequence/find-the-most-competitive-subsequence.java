class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        int top = 0; // pointer to keep track of the stack's top

        for (int i = 0; i < n; i++) {
            // Check if we can pop from stack: 
            // - There are elements in stack (top > 0)
            // - The current number is smaller than the stack's top
            // - If we pop, there are still enough numbers left to complete the subsequence
            while (top > 0 && nums[i] < result[top - 1] && (top - 1 + n - i >= k)) {
                top--;
            }

            // If the stack has less than k elements, push the current element
            if (top < k) {
                result[top++] = nums[i];
            }
        }

        return result;
    }
}