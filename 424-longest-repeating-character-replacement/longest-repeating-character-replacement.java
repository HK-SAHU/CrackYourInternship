class Solution {
    public int characterReplacement(String s, int k) {
        int n= s.length();
        int left=0, right=0, maxFreq=0, maxLen=0;
        int[] charCount= new int[26];
        
        while(right<n){
            // update the frequency of the current character and max frequency
            
            charCount[s.charAt(right) -'A']++;
            maxFreq=Math.max(maxFreq, charCount[s.charAt(right)-'A']);
            
            // If the window size minus maxFreq is greater than k, trim from the left
            if((right-left+1)- maxFreq >k){
                charCount[s.charAt(left)-'A']--;
                left++;
            }
            
            //update the maximum length of the valid substring
            maxLen= Math.max(maxLen, right- left+1);
            right++;
        }
        return maxLen;
    }
}