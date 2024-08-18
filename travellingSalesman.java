import java.util.Arrays;

public class travellingSalesman {
    private static final int INF = 1000000000; // A large number representing infinity
    private int n; // Number of cities
    private int[][] dist; // Distance matrix
    private int[][] dp; // DP table
    private int VISITED_ALL; // All cities visited bitmask

    public travellingSalesman(int[][] dist) {
        this.n = dist.length;
        this.dist = dist;
        this.dp = new int[n][(1 << n)]; // DP table size: n x 2^n
        this.VISITED_ALL = (1 << n) - 1; // All cities visited bitmask: 111...111 with n bits

        // Initialize DP table with -1 (unvisited state)
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    // Method to solve TSP
    public int tsp(int mask, int pos) {
        // Base case: all cities have been visited, return the cost to return to starting city
        if (mask == VISITED_ALL) {
            return dist[pos][0];
        }

        // If this state has already been computed, return its value
        if (dp[pos][mask] != -1) {
            return dp[pos][mask];
        }

        int minCost = INF;

        // Try to go to every other city and compute the minimum cost
        for (int city = 0; city < n; city++) {
            // Check if the city has not been visited yet
            if ((mask & (1 << city)) == 0) {
                int newCost = dist[pos][city] + tsp(mask | (1 << city), city);
                minCost = Math.min(minCost, newCost);
            }
        }

        // Save the result in the DP table and return
        return dp[pos][mask] = minCost;
    }

    public static void main(String[] args) {
        // Example graph: distance matrix
        int[][] dist = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        travellingSalesman tspSolver = new travellingSalesman(dist);
        int result = tspSolver.tsp(1, 0); // Start from city 0 with only city 0 visited
        System.out.println("The minimum cost is: " + result);
    }
}
