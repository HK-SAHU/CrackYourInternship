class Solution {
    public String simplifyPath(String path) {
        Stack<String> st= new Stack<>();
        StringBuilder res= new StringBuilder();   // in this we will be building out string
        
        String[] p = path.split("/");   // this would split my path by / and would give mt only the directories names
        
        for(int i=0;i<p.length;i++){
            if(!st.isEmpty() && p[i].equals("..")){
                st.pop();
            }
            
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")){
                st.push(p[i]);
            }
        }
        
        if(st.isEmpty()) return "/";
        
        while(!st.isEmpty()){
            res.insert(0,st.pop()).insert(0,"/");    // as stack do LIFO but i want y answer in FIFO so that's why i did this
        }
        return res.toString();
        
    }
}