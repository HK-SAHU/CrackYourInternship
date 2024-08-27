class Solution {
    private int count = 0;

    public int countArrangement(int n) {
        // Boolean array to track visited numbers
        boolean[] visited = new boolean[n + 1];
        // Start backtracking from index 1
        backtrack(n, 1, visited);
        return count;
    }

    private void backtrack(int n, int index, boolean[] visited) {
        // If we've placed all numbers, increment count
        if (index > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            // Check if the number is already used or doesn't satisfy the condition
            if (!visited[i] && (i % index == 0 || index % i == 0)) {
                // Mark the number as visited
                visited[i] = true;
                // Recursively place the next number
                backtrack(n, index + 1, visited);
                // Backtrack: unmark the number as visited
                visited[i] = false;
            }
        }
    }
}