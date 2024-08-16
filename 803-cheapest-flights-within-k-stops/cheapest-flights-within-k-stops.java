class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         // Create an adjacency list for the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // Priority Queue to store (cost, current_city, stops_count)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0}); // {cost, node, stops}

        // Distance array to keep track of the minimum cost to reach each node with at most k stops
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[src][0] = 0;

        // While there are nodes to explore
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0], city = current[1], stops = current[2];

            // If destination is reached, return the cost
            if (city == dst) {
                return cost;
            }

            // If stops are within the limit, explore the neighbors
            if (stops <= k) {
                List<int[]> neighbors = graph.getOrDefault(city, new ArrayList<>());
                for (int[] neighbor : neighbors) {
                    int nextCity = neighbor[0], price = neighbor[1];
                    int newCost = cost + price;

                    // Only push to the queue if this path is cheaper with the number of stops
                    if (newCost < dist[nextCity][stops + 1]) {
                        dist[nextCity][stops + 1] = newCost;
                        pq.offer(new int[]{newCost, nextCity, stops + 1});
                    }
                }
            }
        }

        // If no valid route found
        return -1;
    }
}