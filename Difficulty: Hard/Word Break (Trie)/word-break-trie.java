//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // TrieNode class representing each node in the Trie
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }
    
    private static TrieNode root;
    
    // Function to insert a word into the Trie
    private static void insert(String word) {
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
    
    // Function to check if a substring is a word in the Trie
    private static boolean search(String word, int start, int end) {
        TrieNode current = root;
        for (int i = start; i <= end; i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }
    
    // Main function to check if A can be segmented into words from dictionary B
    public static int wordBreak(String A, ArrayList<String> B) {
        root = new TrieNode();
        
        // Insert all words from dictionary B into the Trie
        for (String word : B) {
            insert(word);
        }
        
        int n = A.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        // Fill the DP array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && search(A, j, i - 1)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n] ? 1 : 0;
    }
}