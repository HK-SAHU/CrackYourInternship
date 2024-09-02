class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return false;
        Set<Integer>[] dp = new HashSet[stones.length];
        for (int i = 0; i < stones.length; i++) {
            dp[i] = new HashSet<>();
        }
        dp[0].add(1);

        for (int i = 0; i < stones.length; i++) {
            for (int step : dp[i]) {
                int reach = stones[i] + step;
                if (reach == stones[stones.length - 1]) return true;
                int index = binarySearch(stones, reach);
                if (index != -1) {
                    if (step - 1 > 0) dp[index].add(step - 1);
                    dp[index].add(step);
                    dp[index].add(step + 1);
                }
            }
        }
        return false;
    }

    private int binarySearch(int[] stones, int target) {
        int left = 0, right = stones.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (stones[mid] == target) return mid;
            if (stones[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}