class Solution {
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph
        buildGraph(equations, values);

        // Array to store the result of each query
        double[] results = new double[queries.size()];

        // Evaluate each query using DFS
        for (int i = 0; i < queries.size(); i++) {
            String numerator = queries.get(i).get(0);
            String denominator = queries.get(i).get(1);
            if (!graph.containsKey(numerator) || !graph.containsKey(denominator)) {
                results[i] = -1.0;
            } else if (numerator.equals(denominator)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(numerator, denominator, visited);
            }
        }

        return results;
    }

    private void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, value);
            graph.get(v).put(u, 1 / value);
        }
    }

    private double dfs(String start, String end, Set<String> visited) {
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);

        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(neighbor.getKey(), end, visited);
                if (result != -1.0) {
                    return result * neighbor.getValue();
                }
            }
        }

        return -1.0;
    }
}