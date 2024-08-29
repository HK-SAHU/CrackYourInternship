class Solution {
    public String reorganizeString(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Step 2: Build a max heap based on character frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charCount.get(b) - charCount.get(a));
        maxHeap.addAll(charCount.keySet());

        // Step 3: Construct the result string using the heap
        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 1) {
            // Take out the two most frequent characters
            char first = maxHeap.remove();
            char second = maxHeap.remove();

            // Append them to the result string
            result.append(first);
            result.append(second);

            // Decrement the count of these characters
            charCount.put(first, charCount.get(first) - 1);
            charCount.put(second, charCount.get(second) - 1);

            // If there's any character left, add them back to the heap
            if (charCount.get(first) > 0) {
                maxHeap.add(first);
            }
            if (charCount.get(second) > 0) {
                maxHeap.add(second);
            }
        }

        // Check if there's any character left in the heap
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            if (charCount.get(last) > 1) {
                return ""; // Not possible to reorganize
            }
            result.append(last);
        }

        return result.toString();
    }
}