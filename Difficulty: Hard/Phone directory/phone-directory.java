//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        TreeSet<String> contacts = new TreeSet<>();
    }

    // Insert a contact into the Trie
    static void insert(TrieNode root, String contact) {
        TrieNode node = root;
        for (char ch : contact.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.contacts.add(contact);
        }
    }

    // Search for all contacts that match the given prefix
    static ArrayList<String> search(TrieNode root, String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return new ArrayList<>(Arrays.asList("0"));
            }
            node = node.children[index];
        }
        return new ArrayList<>(node.contacts);
    }

    // Function to display contacts for each prefix of s
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        TrieNode root = new TrieNode();
        // Insert all contacts into the Trie
        for (String con : contact) {
            insert(root, con);
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        // Search for each prefix of s
        StringBuilder prefix = new StringBuilder();
        for (char ch : s.toCharArray()) {
            prefix.append(ch);
            ArrayList<String> contactsForPrefix = search(root, prefix.toString());
            result.add(contactsForPrefix);
        }

        return result;
    }
}