// class Solution {
//     public static String minWindow(String s, String t) {
//         if (s == null || t == null || s.length() < t.length()) {
//             return "";
//         }
//         int cnt = 0;
//         HashMap<Character , Integer> map = new HashMap<>();
//         int l = 0 ;
//         int n= s.length(); 
//         int m = t.length();
//         int minLength = Integer.MAX_VALUE;
//         int startInd =-1;
//         for(int i = 0 ; i<t.length(); i++){
//             map.put(t.charAt(i) , map.getOrDefault(t.charAt(i) ,0)+1);
//         }

//         for(int r = 0 ;r<n; r++){
//             if(map.getOrDefault(s.charAt(r) ,0)>0){
//                 cnt++;
//             }
//             map.put(s.charAt(r) , map.getOrDefault(s.charAt(r),0)-1);
//             while(cnt==m){
//                 if(r-l+1<minLength){
//                     minLength = r-l+1;
//                     startInd = l;
//                 }
//                 map.put(s.charAt(l) , map.get(s.charAt(l))+1);
//                 if(map.get(s.charAt(l))>0){
//                     cnt--;
//                 }
//                 l++;
//             }
//         }

//         if(startInd==-1)return "";
//         return s.substring(startInd ,startInd+minLength );
//     }
// }


class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int count = 0;
        int start = -1;
        int min = Integer.MAX_VALUE;

        int l=0;
        int r=  0;

        for(int i=0; i<m; i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        } 

        while(r<n){
            if(map.getOrDefault(s.charAt(r), 0)>0) count++;
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)-1);
            while(count==m){
                if(r-l+1< min){
                    min = r-l+1;
                    start = l;
                }

                map.put(s.charAt(l), map.get(s.charAt(l))+1);
                if(map.get(s.charAt(l))>0) count--;

                l++;
            }

            r++;
        }

        if(start==-1) return "";
        return s.substring(start, start+min);
    }
}