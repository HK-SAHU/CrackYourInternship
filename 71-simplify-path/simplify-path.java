class Solution {
    public String simplifyPath(String path) {
        //USING STACK
        
//         Stack<String> st= new Stack<>();
//         StringBuilder res= new StringBuilder();   // in this we will be building our string
        
//         String[] p = path.split("/");   // this would split my path by / and would give mt only the directories names
        
//         for(int i=0;i<p.length;i++){
//             if(!st.isEmpty() && p[i].equals("..")){
//                 st.pop();
//             }
            
//             else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")){
//                 st.push(p[i]);
//             }
//         }
        
//         if(st.isEmpty()) return "/";
        
//         while(!st.isEmpty()){
//             res.insert(0,st.pop()).insert(0,"/");    // as stack do LIFO but i want y answer in FIFO so that's why i did this(i popped and insert at the beginging)
//         }
//         return res.toString();
        
        
        // APPROACH 2- USING DEQUE
        
        Deque<String> st= new LinkedList<>();
        StringBuilder res= new StringBuilder();   // in this we will be building our string
        
        String[] p = path.split("/");   // this would split my path by / and would give mt only the directories names
        
        for(int i=0;i<p.length;i++){
            if(!st.isEmpty() && p[i].equals("..")){
                st.poll();
            }
            
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")){
                st.push(p[i]);
            }
        }
        
        if(st.isEmpty()) return "/";
        
        while(!st.isEmpty()){
            res.append("/").append(st.pollLast());   // using deque we can achive FIFO easily
        }
        return res.toString();
        
        
    }
}