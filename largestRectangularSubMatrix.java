import java.util.*;

class GFG {
    // Find the largest subarray with a sum of 0
    public static boolean findSubarrayWithSumZero(int[] arr, int[] sum, int n, int[] start, int[] end) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum[i] = (i == 0) ? arr[0] : sum[i - 1] + arr[i];

            if (sum[i] == 0) {
                start[0] = 0;
                end[0] = i;
                maxLen = i + 1;
            } else if (!sumIndexMap.containsKey(sum[i])) {
                sumIndexMap.put(sum[i], i);
            } else {
                int len = i - sumIndexMap.get(sum[i]);
                if (len > maxLen) {
                    maxLen = len;
                    start[0] = sumIndexMap.get(sum[i]) + 1;
                    end[0] = i;
                }
            }
        }

        return maxLen > 0;
    }

    // Find the largest rectangular submatrix with equal number of 1's and 0's
    public static void findMaxAreaRectWithSumZero(int[][] mat, int row, int col) {
        int[] temp = new int[row];
        int[] startRow = new int[1];
        int[] endRow = new int[1];

        int maxArea = 0;
        int finalLeft = -1, finalRight = -1, finalTop = -1, finalBottom = -1;

        for (int left = 0; left < col; left++) {
            for (int right = left; right < col; right++) {
                for (int i = 0; i < row; i++) {
                    temp[i] += (mat[i][right] != 0) ? 1 : -1;
                }

                if (findSubarrayWithSumZero(temp, new int[row], row, startRow, endRow)) {
                    int area = (right - left + 1) * (endRow[0] - startRow[0] + 1);
                    if (area > maxArea) {
                        maxArea = area;
                        finalTop = startRow[0];
                        finalBottom = endRow[0];
                        finalLeft = left;
                        finalRight = right;
                    }
                }
            }
        }

        if (maxArea == 0) {
            System.out.println("No such rectangular submatrix exists:");
        } else {
            System.out.println("(Top, Left): (" + finalTop + ", " + finalLeft + ")");
            System.out.println("(Bottom, Right): (" + finalBottom + ", " + finalRight + ")");
            System.out.println("Area: " + maxArea + " sq.units");
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 0, 1, 1},
            {0, 1, 1, 0},
            {1, 1, 1, 0},
            {1, 0, 0, 1}
        };
        int row = 4, col = 4;
        findMaxAreaRectWithSumZero(mat, row, col);
    }
}
