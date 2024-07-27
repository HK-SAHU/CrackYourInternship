class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        List<String> li= Arrays.asList(s.split("\\s+"));
        int start=0;
        int end=li.size()-1;
        while(start<end){
            String temp=String.valueOf(li.get(start));
            li.set(start,li.get(end));
            li.set(end,temp);
            start++;
            end--;
        }
        return String.join(" ",li);
        
    }
}