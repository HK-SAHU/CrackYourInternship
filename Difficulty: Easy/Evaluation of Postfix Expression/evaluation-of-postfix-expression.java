//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<S.length();i++){
            char c= S.charAt(i);
            
            
            if(Character.isDigit(c)){
                st.push(c - '0');   // convert char to int
            }
            
            else{
                int val1= st.pop();
                int val2= st.pop();
                
                switch(c){
                    
                    case '+':
                        st.push(val2+val1);
                        break;
                    
                    case '-':
                        st.push(val2-val1);
                        break;
                    case '*':
                        st.push(val2*val1);
                        break;
                    case '/':
                        st.push(val2/val1);
                        break;
                    
                }
            }
        }
        return st.pop();
    }
}