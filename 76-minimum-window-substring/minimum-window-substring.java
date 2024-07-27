class Solution {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int cnt = 0;
        HashMap<Character , Integer> map = new HashMap<>();
        int l = 0 ;
        int n= s.length(); 
        int m = t.length();
        int minLength = Integer.MAX_VALUE;
        int startInd =-1;
        for(int i = 0 ; i<t.length(); i++){
            map.put(t.charAt(i) , map.getOrDefault(t.charAt(i) ,0)+1);
        }

        for(int r = 0 ;r<n; r++){
            if(map.getOrDefault(s.charAt(r) ,0)>0){
                cnt++;
            }
            map.put(s.charAt(r) , map.getOrDefault(s.charAt(r),0)-1);
            while(cnt==m){
                if(r-l+1<minLength){
                    minLength = r-l+1;
                    startInd = l;
                }
                map.put(s.charAt(l) , map.get(s.charAt(l))+1);
                if(map.get(s.charAt(l))>0){
                    cnt--;
                }
                l++;
            }
        }

        if(startInd==-1)return "";
        return s.substring(startInd ,startInd+minLength );
    }
}