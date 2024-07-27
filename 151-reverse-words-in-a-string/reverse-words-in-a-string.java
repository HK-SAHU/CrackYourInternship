class Solution {
    public String reverseWords(String s) {
        s=s.trim();   // removes any leading and trailing whitespace from the string
        String[] word= s.split("\\s+");
        
        int start=0;
        int end=word.length-1;
        while(start<end){
            String temp= word[start];
            word[start]= word[end];
            word[end]= temp;
            start++;
            end--;
        }
        return String.join(" ", word);
        
    }
}