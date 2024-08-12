class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // Step 1: Build the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            graph.computeIfAbsent(pair[0], x -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], x -> new ArrayList<>()).add(pair[0]);
        }

        // Step 2: Find the start of the array (an element with only one neighbor)
        int start = 0;
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                start = key;
                break;
            }
        }

        // Step 3: Restore the array
        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        Set<Integer> visited = new HashSet<>();
        int index = 0;
        
        result[index++] = start;
        visited.add(start);
        
        while (index < n) {
            int current = result[index - 1];
            for (int neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    result[index++] = neighbor;
                    visited.add(neighbor);
                    break;
                }
            }
        }
        
        return result;
    }
}