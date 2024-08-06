class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st= new Stack<>();
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")){
                
                int val1= st.pop();
                int val2= st.pop();
                
                switch(token){
                    
                    case "+":
                        st.push(val2+val1);
                        break;
                    
                    case "-":
                        st.push(val2-val1);
                        break;
                    case "*":
                        st.push(val2*val1);
                        break;
                    case "/":
                        st.push(val2/val1);
                        break;
                    
                }
            }
            else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}