class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Initialize the heap with the first element of each row.
        for (int r = 0; r < Math.min(n, k); r++) {
            minHeap.offer(new int[]{matrix[r][0], r, 0});
        }

        int count = 0;
        int result = 0;
        while (count < k) {
            int[] current = minHeap.poll();
            result = current[0];
            int r = current[1], c = current[2];
            
            // If there is a next element in the row, add it to the heap
            if (c < n - 1) {
                minHeap.offer(new int[]{matrix[r][c + 1], r, c + 1});
            }

            count++;
        }

        return result;
    }
}