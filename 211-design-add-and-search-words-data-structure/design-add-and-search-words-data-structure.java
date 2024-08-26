class WordDictionary {

    // TrieNode class representing each node in the Trie
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    // Constructor to initialize the WordDictionary object
    public WordDictionary() {
        root = new TrieNode();
    }

    // Method to add a word to the data structure
    public void addWord(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    // Method to search for a word in the data structure
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    // Helper method to perform the search recursively
    private boolean searchInNode(String word, TrieNode node) {
        TrieNode current = node;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (TrieNode child : current.children) {
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false; // If no children nodes match
            } else {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
        }
        return current.isEndOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */