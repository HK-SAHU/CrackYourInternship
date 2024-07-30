class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder columnTitle= new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            int remainder= columnNumber%26;
            char ch= (char) (remainder + 'A');
            columnTitle.insert(0,ch);
            columnNumber= columnNumber/26;
        }
        return columnTitle.toString();
    }
}