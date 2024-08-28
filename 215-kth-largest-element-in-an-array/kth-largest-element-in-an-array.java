class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store the top k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate over all elements in the array
        for (int num : nums) {
            // Add the current element to the heap
            minHeap.add(num);

            // If the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the kth largest element
        return minHeap.peek();
    }
}