class Solution {
public:
    
    int nthUglyNumber(int n) {
        if (n <= 0) return 0; // Invalid input
        vector<int> uglyNumbers(n);
        uglyNumbers[0] = 1; // First ugly number is 1
        int index2 = 0, index3 = 0, index5 = 0;

        for (int i = 1; i < n; ++i) {
            int nextUgly = min({uglyNumbers[index2] * 2, uglyNumbers[index3] * 3, uglyNumbers[index5] * 5});
            uglyNumbers[i] = nextUgly;

            // Update the indices for 2, 3, and 5 factors
            if (nextUgly == uglyNumbers[index2] * 2) ++index2;
            if (nextUgly == uglyNumbers[index3] * 3) ++index3;
            if (nextUgly == uglyNumbers[index5] * 5) ++index5;
        }

        return uglyNumbers[n - 1];
    }
};