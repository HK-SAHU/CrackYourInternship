//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        if (string_list==null || string_list.length==0) return new ArrayList<>();
        
        
        HashMap<String, List<String>> freqMap= new HashMap<>();
        
        for(String str: string_list){    // iterating through the array of string
            String freqString =getFreqString(str);
            
            if(freqMap.containsKey(freqString)){   // if the frequency string is already in the map
                freqMap.get(freqString).add(str);
            }
            
            else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                freqMap.put(freqString, strList);
            }
        }
        return new ArrayList<>(freqMap.values());
        
    }
    
    public static String getFreqString(String str){
        int[] freq= new int[26];
        
        for(char c :str.toCharArray()){
            freq[c - 'a']++;
        }
        
        StringBuilder freqString= new StringBuilder();
        
        char c='a';
        
        for(int i:freq){
            freqString.append(c);
            freqString.append(i);
            c++;
        }
        return freqString.toString();
    }
}
