class Solution {
    public String removeKdigits(String num, int k) {
        // queu to store the digits of the final number
        Deque<Character> q = new LinkedList<>();
        
        for (char digit : num.toCharArray()) {
            // Remove characters from the queue if the current digit is smaller
            // and we still have k digits left to remove
            while (!q.isEmpty() && k > 0 && q.peekLast() > digit) {
                q.pollLast();
                k--;
            }
            q.offerLast(digit);
        }
        
        // If there are still k digits left to remove, remove from the end
        for (int i = 0; i < k; i++) {
            q.pollLast();
        }
        
        // Construct the final number and remove leading zeros
        StringBuilder result = new StringBuilder();
        while (!q.isEmpty()) {
            result.append(q.pollFirst());
        }
        
        // Remove leading zeros
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        // Return "0" if the final result is empty, else return the number
        return result.length() == 0 ? "0" : result.toString();
    }
}