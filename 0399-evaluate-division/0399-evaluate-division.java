class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = populateGraph(equations, values);
        
        double[] answers = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            answers[i] = calculate(a, b, graph);
        }
        return answers;
    }

    private Map<String, Map<String, Double>> populateGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            if (!graph.containsKey(a)) {
                graph.put(a, new HashMap<>());
            }
            graph.get(a).put(b, value);
            if (!graph.containsKey(b)) {
                graph.put(b, new HashMap<>());
            }
            graph.get(b).put(a, 1.0 / value);
        }
        return graph;
    }

    private double calculate(String a, String b, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(a) || !graph.containsKey(b)) return -1.0;
        if (Objects.equals(a, b)) return 1.0;
        
        return helper(a, b, graph, new HashSet<>(), 1.0);
    }

    private double helper(String a, String b, Map<String, Map<String, Double>> graph,  Set<String> visited, double product) {
        visited.add(a);
        Map<String, Double> neighbors = graph.get(a);
        
        if (neighbors.containsKey(b)) {
            return product * neighbors.get(b);
        }

        for (var entry : neighbors.entrySet()) {
            String next = entry.getKey();
            if (visited.contains(next)) continue;
            double result = helper(next, b, graph, visited, product * entry.getValue());
            if (result != -1.0) return result;
        }
        return -1.0;
    }
}