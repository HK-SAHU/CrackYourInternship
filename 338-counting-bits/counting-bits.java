class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // i & (i - 1) drops the lowest set bit.
            // For example, 14 (1110) & 13 (1101) = 12 (1100)
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}