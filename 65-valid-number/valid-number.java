class Solution {
    public boolean isNumber(String s) {
        // we need 3 falg variable and 1 count variable to check for the valid number
        boolean digitSeen= false, eSeen=false, dotSeen=false;
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            //digit
            if(Character.isDigit(ch)){
                digitSeen=true;
                
            }
            
            //minus/plus
            else if(ch=='+' || ch=='-'){
                if(count>1){
                    return false;
                }
                if(i>0 && s.charAt(i-1)!='e' && s.charAt(i-1)!='E'){   // if is not this type of number 23E+4 (+- at the middle of the numbers but not with e/E)
                    return false;
                }
                if(i==s.length()-1){
                    return false;
                }
                count++;
                
            }
            
            
            //dot
            else if(ch=='.'){
                if(eSeen || dotSeen){   // if these are already seen
                    return false;
                }
                if(i==s.length()-1 && !digitSeen){
                    return false;
                }
                dotSeen= true;
                
            }
            
            
            //e/E
            else if(ch=='e' || ch=='E'){
                if(eSeen || !digitSeen || i==s.length()-1){    // already seen
                    return false;
                }
                
                eSeen= true;
            }
            else{
                return false;
            }
            
            
        }
        return true;
    }
}