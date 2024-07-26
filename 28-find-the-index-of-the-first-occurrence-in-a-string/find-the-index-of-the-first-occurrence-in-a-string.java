class Solution {
    public int strStr(String haystack, String needle) {
        // int hLen = haystack.length();
        // int nLen = needle.length();
        // int nIndex = 0;
        // for(int i=0; i<hLen; i++){
        //     // as long as the characters are equal, increment needleIndex
        //     if(haystack.charAt(i)==needle.charAt(nIndex)){
        //         nIndex++;
        //     }
        //     else{
        //         // start from the next index of previous start index
        //         i=i-nIndex;
        //         // needle should start from index 0
        //         nIndex=0;
        //     }
        //     // check if needleIndex reached needle length
        //     if(nIndex==nLen){
        //         // return the first index
        //         return i-nLen+1;
        //     }
        // }
        // return -1;
        
        // for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
        //     if(haystack.substring(i,j).equals(needle)){
        //         return i;
        //     }
        // }
        // return -1;
        
        int hLen = haystack.length();
        int nLen = needle.length();

        // If needle is empty, return 0
        if (nLen == 0) return 0;

        // Iterate through the haystack
        for (int i = 0; i <= hLen - nLen; i++) {
            int j = 0;
            // Check if the substring matches the needle
            while (j < nLen && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            // If we matched the entire needle, return the start index
            if (j == nLen) {
                return i;
            }
        }

        // If needle is not found in haystack, return -1
        return -1;
    }

}