//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t > 0) {
            String s = sc.nextLine();
            Solution ob = new Solution();
            if (ob.sentencePalindrome(s))
                System.out.println("true");
            else
                System.out.println("false");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {

    public boolean sentencePalindrome(String s) {
        
        // create the new string without alphanumeric characters
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        
        // reverse od the new String
        StringBuilder sb1= new StringBuilder(sb.toString());
        sb1.reverse();
        
        // compare the two strings and return 
        return sb.toString().equals(sb1.toString());
        
    }
}