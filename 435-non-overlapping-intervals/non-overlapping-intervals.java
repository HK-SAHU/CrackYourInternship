class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = intervals[0][1]; // Initial end time of the first interval

        for (int i = 1; i < intervals.length; i++) {
            // If the start of the current interval is less than the end of the previous interval
            if (intervals[i][0] < end) {
                // There is an overlap, increment count
                count++;
            } else {
                // Update end to the current interval's end
                end = intervals[i][1];
            }
        }

        return count;
    }
}