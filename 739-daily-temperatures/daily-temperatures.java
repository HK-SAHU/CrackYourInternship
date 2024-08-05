class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
        Stack<Integer> st= new Stack<>();
        int[] result= new int[n];
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i]> temperatures[st.peek()]){
                int prevIndex= st.pop();
                result[prevIndex]= i-prevIndex;
            }
            st.push(i);
        }
        return result;
    }
}