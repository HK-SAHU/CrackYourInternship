class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }
    
    public String buildString(String str){
        StringBuilder result= new StringBuilder();
        for(char ch: str.toCharArray()){
            if(ch!='#'){
                result.append(ch);
            }
            else if(result.length()>0){
                result.deleteCharAt(result.length()-1);
            }
        }
        return result.toString();
    }
}