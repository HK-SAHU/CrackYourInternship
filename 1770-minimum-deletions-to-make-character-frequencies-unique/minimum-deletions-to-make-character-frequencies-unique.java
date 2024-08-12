class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        
        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Step 2: Sort the frequencies in descending order
        Arrays.sort(freq);
        
        int deletions = 0;
        int maxAllowed = s.length();
        
        // Step 3: Iterate from the most frequent to the least frequent
        for (int i = 25; i >= 0 && freq[i] > 0; i--) {
            if (freq[i] > maxAllowed) {
                // We need to delete characters
                deletions += freq[i] - maxAllowed;
                freq[i] = maxAllowed;
            }
            maxAllowed = Math.max(0, freq[i] - 1);  // Ensure next frequency is strictly less
        }
        
        return deletions;
    }
}