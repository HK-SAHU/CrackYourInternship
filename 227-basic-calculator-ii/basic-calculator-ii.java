class Solution {
    public int calculate(String s) {
        if(s==null ||s.length()==0) return 0;
        
        Stack<Integer> st= new Stack<>();
        
        int curr=0;    // hold the current number
        char op='+';    // hold the operation that needs to be done
        
        char[] ch= s.toCharArray();
        for(int i=0;i<ch.length;i++){
            // now we have two condition if the character is a digit or it's not a digit
            if(Character.isDigit(ch[i])){
                curr= curr*10+ch[i]-'0';  // ch[i]-'0' for ascii value 51-48 ==3-0
                //why *10 beacuse the next number will be in the tens place
            }
            
            if(!Character.isDigit(ch[i]) && ch[i]!=' ' || i==s.length()-1){
                if(op=='+'){
                    st.push(curr);
                }
                
                else if(op=='-'){
                    st.push(-curr);
                }
                
                else if(op=='*'){
                    st.push(st.pop()*curr);
                }
                
                else if(op=='/'){
                    st.push(st.pop()/curr);
                }
                op=ch[i];
                curr=0;
            }
        }  
        int result=0;
        while(!st.isEmpty()){
            result+=st.pop();
        }
        return result;
        
    }
}