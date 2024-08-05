class StockSpanner {
    public Stack<int[]> st;

    public StockSpanner() {
        st= new Stack<>();
    }
    
    public int next(int price) {
        int span=1;
        
        while(!st.isEmpty() && st.peek()[0] <= price){
            span+=st.pop()[1];
        } 
        st.push(new int[] {price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */


/*   brute force solution

     public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];

        // Traverse each price and calculate span
        for (int i = 0; i < n; i++) {
            span[i] = 1; // Initialize span value

            // Traverse left to find the span value
            for (int j = i - 1; j >= 0 && prices[j] <= prices[i]; j--) {
                span[i]++;
            }
        }

        return span;
    }

*/