class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        // Max-heap to store (yi - xi, xi)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int maxValue = Integer.MIN_VALUE;

        for (int[] point : points) {
            int xj = point[0];
            int yj = point[1];

            // Remove points from the heap where xj - xi > k
            while (!pq.isEmpty() && xj - pq.peek()[1] > k) {
                pq.poll();
            }

            // Calculate max value if the heap is not empty
            if (!pq.isEmpty()) {
                maxValue = Math.max(maxValue, pq.peek()[0] + yj + xj);
            }

            // Push the current point (yi - xi, xi) to the heap
            pq.offer(new int[]{yj - xj, xj});
        }

        return maxValue;
    }
}