class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // if (equations.size() != values.length) {
        //     throw new IllegalArgumentException("Invalid input");
        // }

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
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String first = queries.get(i).get(0);
            String second = queries.get(i).get(1);
            results[i] = calcQuery(first, second, graph);
        }
        return results;
    }

    private double calcQuery(String first, String second, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(first) || !graph.containsKey(second)) return -1.0;
        if (Objects.equals(first, second)) return 1.0;

        return calcQuery(first, second, graph, new HashSet<>(), 1.0);
    }

    private double calcQuery(String first, String second, Map<String, Map<String, Double>> graph, Set<String> visited, double product) {
        visited.add(first);

        Map<String, Double> neighbors = graph.get(first);
        if (neighbors.containsKey(second)) {
            return product * neighbors.get(second);
        }
        for (var entry : neighbors.entrySet()) {
            String next = entry.getKey();
            if (visited.contains(next)) continue;
            double result = calcQuery(next, second, graph, visited, product * entry.getValue());
            if (result != -1.0) return result;
        }
        return -1.0;
    }
}