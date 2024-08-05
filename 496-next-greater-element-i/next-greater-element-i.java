class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        int[] nextGreater = new int[nums1.length];

        // Traverse nums2 from the end
        for (int i = nums2.length - 1; i >= 0; i--) {
            int element = nums2[i];
            
            // Remove elements from the stack smaller than or equal to the current element
            while (!st.isEmpty() && st.peek() <= element) {
                st.pop();
            }
            
            // If stack is empty, there is no greater element, else the top of the stack is the next greater element
            if (st.isEmpty()) {
                nextGreaterMap.put(element, -1);
            } else {
                nextGreaterMap.put(element, st.peek());
            }
            
            // Push the current element onto the stack
            st.push(element);
        }
        
        // Build the result array for nums1 using the next greater elements from the map
        for (int i = 0; i < nums1.length; i++) {
            nextGreater[i] = nextGreaterMap.get(nums1[i]);
        }
        
        return nextGreater;
        
    }
}