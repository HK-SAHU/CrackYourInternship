class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        
        // Initialize the search space
        for (int num : nums) {
            left = Math.max(left, num);  // max single element
            right += num;  // sum of all elements
        }
        
        // Perform binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If it's possible to split with this max sum, move left to mid
            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;  // left will be the minimized largest sum
    }
    
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int subarrayCount = 1;
        int currentSum = 0;
        
        for (int num : nums) {
            // Add num to the current subarray sum
            currentSum += num;
            
            // If currentSum exceeds maxSum, start a new subarray
            if (currentSum > maxSum) {
                subarrayCount++;
                currentSum = num;
                
                // If the number of subarrays exceeds k, return false
                if (subarrayCount > k) {
                    return false;
                }
            }
        }
        
        return true;
    }
}