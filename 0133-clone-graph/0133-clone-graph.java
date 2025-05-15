/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(node);
        visited.add(node.val);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (!map.containsKey(curr.val)) {
                map.put(curr.val, new Node(curr.val));
            }
            Node currCopy = map.get(curr.val);

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    map.put(neighbor.val, new Node(neighbor.val));
                }
                Node neighborCopy = map.get(neighbor.val);
                currCopy.neighbors.add(neighborCopy);
                if (!visited.contains(neighbor.val)) {
                    q.add(neighbor);
                    visited.add(neighbor.val);
                }
            }
        }

        return map.get(node.val);
    }
}