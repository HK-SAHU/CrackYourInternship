class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;  // Initialize total time to 0
        int n = colors.length();  // Get the length of the colors string
        
        // Traverse the colors string from the second character onwards
        for (int i = 1; i < n; i++) {
            // If the current balloon is the same color as the previous one
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Add the smaller time to remove to total time
                totalTime += Math.min(neededTime[i], neededTime[i - 1]);
                
                // Keep the larger time for the current position to ensure maximum savings
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        
        return totalTime;  // Return the total time required to make the rope colorful
    }
}