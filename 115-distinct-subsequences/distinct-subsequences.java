class Solution {
    static int prime = (int) (Math.pow(10, 9) + 7);
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int[] prev = new int[m+1];
        
        // Initialize the first element to 1 because there's one empty subsequence in any string.
        prev[0]=1;
        
        for(int i=1;i<n+1;i++){
            for(int j=m;j>=1;j--){  // Reverse direction for updating
                
                // If the characters match, we can either include this character in the subsequence
                    // or exclude it. So, we add the counts from both possibilities.
                if(s.charAt(i-1)==t.charAt(j-1)){
                    prev[j]= (prev[j-1]+prev[j])% prime;
                }
                
                else{
                    // If the characters don't match, we can only exclude this character.
                    prev[j]=prev[j];   // This statement is not necessary, as it doesn't change the value.
                }
            }
        }
        return prev[m];
    }
}