class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null  || strs.length==0) return  new ArrayList<>();
        
        Map<String, List<String>> freqMap= new HashMap<>();
        
        
        for(String str:strs){
            String freqString= getFreqString(str);
            
            // if the frequency string is prresent add the string to the list
            
            if(freqMap.containsKey(freqString)){
                freqMap.get(freqString).add(str);
            }
            
            else{     // create the new list
                List<String> strList= new ArrayList<>();
                strList.add(str);
                freqMap.put(freqString, strList);
            }
        }
        return new ArrayList<>(freqMap.values());
    }
    
    public static String getFreqString(String str){
        // frequency bucket
        int[] freq = new int[26];
        for(char c: str.toCharArray()){
            freq[c-'a']++;
        }
        
        StringBuilder freqString= new StringBuilder();
        char c= 'a';
        for(int i:freq){
            freqString.append(c);
            freqString.append(i);
            c++;
        }
        return freqString.toString();
    }
}