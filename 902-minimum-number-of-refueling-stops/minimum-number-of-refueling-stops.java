class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Max heap to store the fuel amounts
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int currentFuel = startFuel;
        int stops = 0;
        int index = 0;
        int n = stations.length;

        // Loop until we reach or exceed the target
        while (currentFuel < target) {
            // Add all stations that we can reach with the current fuel
            while (index < n && stations[index][0] <= currentFuel) {
                maxHeap.offer(stations[index][1]);
                index++;
            }

            // If there are no stations left and we can't reach the target, return -1
            if (maxHeap.isEmpty()) {
                return -1;
            }

            // Refuel with the largest available fuel from the heap
            currentFuel += maxHeap.poll();
            stops++;
        }

        return stops;
    }
}