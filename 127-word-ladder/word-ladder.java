class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // endWord is not in the wordList, so no valid transformation
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1; // start with level 1 (the beginWord itself)

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                
                // Generate all possible transformations
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordChars = currentWord.toCharArray();
                    
                    // Try changing each character
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        // Check if the transformed word is the endWord
                        if (newWord.equals(endWord)) {
                            return level + 1; // Found the shortest path to endWord
                        }
                        
                        // Otherwise, if it's a valid word, add it to the queue
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // Mark as visited
                        }
                    }
                }
            }
            level++;
        }

        return 0; // No transformation sequence exists
    }
}