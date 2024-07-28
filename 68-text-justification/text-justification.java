class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;

            // Collect words for the current line
            while (last < words.length) {
                // Check if adding the next word exceeds the maxWidth
                if (totalChars + 1 + words[last].length() > maxWidth) {
                    break;
                }
                totalChars += 1 + words[last].length(); // 1 is for the space between words
                last++;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            int diff = last - index - 1; // Number of spaces to insert

            // If the current line is the last line or contains only one word, left justify
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    builder.append(" ").append(words[i]);
                }
                // Fill the remaining spaces at the end
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } else {
                // Calculate the number of spaces
                int spaces = (maxWidth - totalChars) / diff;
                int extraSpaces = (maxWidth - totalChars) % diff;

                // Distribute spaces evenly between words, giving extra spaces from left to right
                for (int i = index + 1; i < last; i++) {
                    for (int j = 0; j <= (spaces + ((i - index - 1) < extraSpaces ? 1 : 0)); j++) {
                        builder.append(" ");
                    }
                    builder.append(words[i]);
                }
            }

            // Add the justified line to the result
            result.add(builder.toString());
            index = last; // Move to the next line
        }

        return result; // Return the list of justified lines
    }
}