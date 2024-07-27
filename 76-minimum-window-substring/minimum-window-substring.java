class Solution {
        public static String minWindow(String s, String p) {
            if (s == null || p == null || s.length() < p.length()) {
                return "";
            }

            // Frequency map for characters in p
            Map<Character, Integer> mapP = new HashMap<>();
            for (char c : p.toCharArray()) {
                mapP.put(c, mapP.getOrDefault(c, 0) + 1);
            }

            // Frequency map for characters in the current window
            Map<Character, Integer> mapS = new HashMap<>();
            int left = 0, right = 0;
            int minLength = Integer.MAX_VALUE;
            int start = 0;
            int matchCount = 0;

            while (right < s.length()) {
                char charRight = s.charAt(right);

                if (mapP.containsKey(charRight)) {
                    mapS.put(charRight, mapS.getOrDefault(charRight, 0) + 1);
                    if (mapS.get(charRight).intValue() == mapP.get(charRight).intValue()) {
                        matchCount++;
                    }
                }

                // When all characters are matched, try to shrink the window
                while (matchCount == mapP.size()) {
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        start = left;
                    }

                    char charLeft = s.charAt(left);
                    if (mapP.containsKey(charLeft)) {
                        mapS.put(charLeft, mapS.get(charLeft) - 1);
                        if (mapS.get(charLeft).intValue() < mapP.get(charLeft).intValue()) {
                            matchCount--;
                        }
                    }
                    left++;
                }

                right++;
            }

            return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
        }
}