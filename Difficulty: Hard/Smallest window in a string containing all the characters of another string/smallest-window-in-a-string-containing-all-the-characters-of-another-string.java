//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String t)
    {
        int n = s.length();
        int m = t.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int count = 0;
        int start = -1;
        int min = Integer.MAX_VALUE;

        int l=0;
        int r=  0;

        for(int i=0; i<m; i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        } 

        while(r<n){
            if(map.getOrDefault(s.charAt(r), 0)>0) count++;
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)-1);
            while(count==m){
                if(r-l+1< min){
                    min = r-l+1;
                    start = l;
                }

                map.put(s.charAt(l), map.get(s.charAt(l))+1);
                if(map.get(s.charAt(l))>0) count--;

                l++;
            }

            r++;
        }

        if(start==-1) return "-1";
        return s.substring(start, start+min);
    }
}