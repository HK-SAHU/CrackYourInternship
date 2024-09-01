class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int maxLength = 0;

        for (int num : nums) {
            int i = 0, j = maxLength;
            while (i < j) {
                int mid = (i + j) / 2;
                if (dp[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            dp[i] = num;
            if (i == maxLength) {
                maxLength++;
            }
        }

        return maxLength;
    }
}
