class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        return calcQueries(graph, queries);
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            double value = values[i];
            if (!graph.containsKey(first)) {
                graph.put(first, new HashMap<>());
            }
            graph.get(first).put(second, value);
            if (!graph.containsKey(second)) {
                graph.put(second, new HashMap<>());
            }
            graph.get(second).put(first, 1.0 / value);
        }
        return graph;
    }

    private double[] calcQueries(Map<String, Map<String, Double>> graph, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String first = queries.get(i).get(0);
            String second = queries.get(i).get(1);
            result[i] = calcQuery(graph, first, second, new HashSet<>(), 1.0);
        }
        return result;
    }

    private double calcQuery(Map<String, Map<String, Double>> graph, String first, String second, Set<String> visited, double product) {
        if (!graph.containsKey(first)) return -1.0;
        if (Objects.equals(first, second)) return 1.0;
        visited.add(first);

        Map<String, Double> neighbors = graph.get(first);

        if (neighbors.containsKey(second)) {
            return product * neighbors.get(second);
        }

        for (var neighbor : neighbors.entrySet()) {
            String next = neighbor.getKey();
            if (visited.contains(next)) continue;
            double value = calcQuery(graph, next, second, visited, product * neighbor.getValue());
            if (value != -1.0) return value;
        }

        return -1.0;
    }
}