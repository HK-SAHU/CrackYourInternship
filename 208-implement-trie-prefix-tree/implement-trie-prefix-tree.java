class TrieNode {
    // Each node contains an array of children and a flag to mark the end of a word
    TrieNode[] children;
    boolean isEndOfWord;

    // Constructor initializes the children array and end-of-word flag
    public TrieNode() {
        children = new TrieNode[26];  // Initialize children for each letter a-z
        isEndOfWord = false;          // Initially, no word ends at this node
    }
}


class Trie {

    private final TrieNode root;  // The root of the Trie

    // Constructor initializes the Trie with an empty root node
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        // Iterate over each character in the word
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';  // Find the index for the character (0 for 'a', 1 for 'b', ...)
            // If the child node does not exist, create it
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            // Move to the next node
            node = node.children[index];
        }
        // Mark the end of the word
        node.isEndOfWord = true;
    }

    // Returns true if the word is in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        // Iterate over each character in the word
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            // If a child node does not exist, the word is not present
            if (node.children[index] == null) {
                return false;
            }
            // Move to the next node
            node = node.children[index];
        }
        // The word is present if the end-of-word flag is set
        return node.isEndOfWord;
    }

    // Returns true if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        // Iterate over each character in the prefix
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            // If a child node does not exist, no word with the prefix is present
            if (node.children[index] == null) {
                return false;
            }
            // Move to the next node
            node = node.children[index];
        }
        // The prefix exists in the Trie
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */