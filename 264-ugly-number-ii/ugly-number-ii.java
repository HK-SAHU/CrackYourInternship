class Solution {
    public int nthUglyNumber(int n) {
        // Array to hold the ugly numbers
        int[] ugly = new int[n];
        ugly[0] = 1;  // 1 is the first ugly number
        
        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;
        
        for (int i = 1; i < n; i++) {
            // Choose the smallest next ugly number
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            ugly[i] = nextUgly;
            
            // Update the pointers and next values
            if (nextUgly == next2) {
                i2++;
                next2 = ugly[i2] * 2;
            }
            if (nextUgly == next3) {
                i3++;
                next3 = ugly[i3] * 3;
            }
            if (nextUgly == next5) {
                i5++;
                next5 = ugly[i5] * 5;
            }
        }
        
        return ugly[n - 1];  // Return the nth ugly number
    }
}