class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) return result;

        // Create a map to store the reverse of each word and its index
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        // Iterate through each word to find palindrome pairs
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            int currentLength = currentWord.length();

            // Check different cases for palindrome pairs
            for (int j = 0; j <= currentLength; j++) {
                String left = currentWord.substring(0, j);
                String right = currentWord.substring(j);

                // Case 1: If left part is a palindrome and there exists a reversed right part in the map
                if (isPalindrome(left)) {
                    Integer index = wordMap.get(right);
                    if (index != null && index != i) {
                        result.add(Arrays.asList(index, i));
                    }
                }

                // Case 2: If right part is a palindrome and there exists a reversed left part in the map
                if (j != currentLength && isPalindrome(right)) {
                    Integer index = wordMap.get(left);
                    if (index != null && index != i) {
                        result.add(Arrays.asList(i, index));
                    }
                }
            }
        }
        return result;
    }

    // Helper method to check if a given string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}