//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    // Function to find all palindromic partitions of a string
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrack(S, 0, new ArrayList<>(), result);
        return result;
    }

    // Backtracking function to generate palindromic partitions
    private static void backtrack(String s, int start, ArrayList<String> current, ArrayList<ArrayList<String>> result) {
        if (start == s.length()) {
            // If we've reached the end of the string, add the current partition to the result
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            // Check if substring s[start:end+1] is a palindrome
            if (isPalindrome(s, start, end)) {
                // If it is, add it to the current list and recursively explore further
                current.add(s.substring(start, end + 1));
                backtrack(s, end + 1, current, result);
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }

    // Helper function to check if a substring is a palindrome
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}