class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD= 1_000_000_007;
        int n= arr.length;
        
        Stack<Integer> st= new Stack<>();
        
        int[] left= new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] >=arr[i]){
                st.pop();
            }
            left[i]= st.isEmpty()? (i+1): (i- st.peek());
            st.push(i);
        }
        
        st.clear();
        
        int[] right= new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >arr[i]){
                st.pop();
            }
            right[i]= st.isEmpty()? (n-i): (st.peek() -i);
            st.push(i);
        }
        
        // calculate the result
        
        long result=0;
        for(int i =0;i<n;i++){
            result= (result+(long) arr[i] * left[i] * right[i]) %MOD;
        }
        return (int) result;
    }
}