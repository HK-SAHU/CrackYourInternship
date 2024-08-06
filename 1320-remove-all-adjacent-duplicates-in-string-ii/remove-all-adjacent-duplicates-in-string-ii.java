class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st= new Stack<>();
        for(char c: s.toCharArray()){
            if(!st.isEmpty() && st.peek()[0]==c){
                st.peek()[1]++;
            }
            else{
                st.push(new int[] {c, 1});
            }
            if(st.peek()[1]==k){
                st.pop();
            }
        }
        
        StringBuilder sc= new StringBuilder();
        while(!st.isEmpty()){
            int[] top= st.pop();
            while(top[1]-- > 0){
                sc.append((char)top[0]);
            }
            
        }
        
        return sc.reverse().toString();
        
        
//         int count=1;
//         for(int i =1;i<s.length();i++){
//             if(s.charAt(i)==s.charAt(i-1)){
//                 count++;
//             }
//             else{
//                 count=1;  // reset
//             }
            
//             if(count==k){
//                 String reduced= s.substring(0,i-k+1)+s.substring(i+1);
//                 return removeDuplicates(reduced,k);
//             }
//         }
//         return s;
    }
}