class NumArray {

    private int[] segmentTree;  // Segment tree array to store sums
    private int n;  // Size of the input array

    // Constructor to initialize the NumArray object
    public NumArray(int[] nums) {
        if (nums.length == 0) return;
        n = nums.length;
        segmentTree = new int[4 * n];  // Allocate memory for the segment tree
        buildSegmentTree(nums, 0, 0, n - 1);  // Build the segment tree
    }

    // Helper function to build the segment tree
    private void buildSegmentTree(int[] nums, int treeIndex, int lo, int hi) {
        if (lo == hi) {  // If it's a leaf node, store the value in the segment tree
            segmentTree[treeIndex] = nums[lo];
        } else {
            int mid = lo + (hi - lo) / 2;
            int leftChild = 2 * treeIndex + 1;
            int rightChild = 2 * treeIndex + 2;
            buildSegmentTree(nums, leftChild, lo, mid);  // Build the left subtree
            buildSegmentTree(nums, rightChild, mid + 1, hi);  // Build the right subtree
            segmentTree[treeIndex] = segmentTree[leftChild] + segmentTree[rightChild];  // Calculate the sum of the current node
        }
    }

    // Function to update the value at a specific index
    public void update(int index, int val) {
        updateSegmentTree(0, 0, n - 1, index, val);
    }

    // Helper function to update the segment tree
    private void updateSegmentTree(int treeIndex, int lo, int hi, int arrIndex, int val) {
        if (lo == hi) {  // If it's a leaf node, update the value
            segmentTree[treeIndex] = val;
        } else {
            int mid = lo + (hi - lo) / 2;
            int leftChild = 2 * treeIndex + 1;
            int rightChild = 2 * treeIndex + 2;

            if (arrIndex > mid) {
                updateSegmentTree(rightChild, mid + 1, hi, arrIndex, val);  // Update the right subtree
            } else {
                updateSegmentTree(leftChild, lo, mid, arrIndex, val);  // Update the left subtree
            }

            segmentTree[treeIndex] = segmentTree[leftChild] + segmentTree[rightChild];  // Update the sum of the current node
        }
    }

    // Function to calculate the sum of a specific range
    public int sumRange(int left, int right) {
        return querySegmentTree(0, 0, n - 1, left, right);
    }

    // Helper function to perform range sum query on the segment tree
    private int querySegmentTree(int treeIndex, int lo, int hi, int i, int j) {
        if (lo > j || hi < i) return 0;  // If the range is out of bounds, return 0
        if (i <= lo && hi <= j) return segmentTree[treeIndex];  // If the range is within bounds, return the sum

        int mid = lo + (hi - lo) / 2;
        if (i > mid) {
            return querySegmentTree(2 * treeIndex + 2, mid + 1, hi, i, j);  // Query the right subtree
        } else if (j <= mid) {
            return querySegmentTree(2 * treeIndex + 1, lo, mid, i, j);  // Query the left subtree
        }

        int leftQuery = querySegmentTree(2 * treeIndex + 1, lo, mid, i, mid);
        int rightQuery = querySegmentTree(2 * treeIndex + 2, mid + 1, hi, mid + 1, j);
        return leftQuery + rightQuery;  // Return the sum of the left and right queries
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */