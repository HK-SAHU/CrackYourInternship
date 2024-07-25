class Solution {
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        Stack<Integer> st= new Stack<>();
        int[] left = new int[n];
        int[] right= new int[n];
        
        // 
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) left[i]=0;  // if it is first index or the current index value has no value less than that.
            else left[i]=st.peek()+1;
            st.push(i);
        }
        
        st.clear();  // clear the stack so that it can be re used
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) right[i]=n-1;
            else right[i]= st.peek()-1;
            st.push(i);
        }
        
        int maxArea=0;
        for(int i=0;i<n;i++){
            maxArea= Math.max(maxArea, heights[i]* (right[i]- left[i]+1));
        }
        return maxArea;
        
    }
}