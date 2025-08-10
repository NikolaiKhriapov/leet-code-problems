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

        Set<Node> oldNodes = new HashSet<>();
        Map<Integer, Node> mapNewNodes = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            oldNodes.add(curr);
            mapNewNodes.put(curr.val, new Node(curr.val, new ArrayList<>()));
            for (Node neighbor : curr.neighbors) {
                if (!oldNodes.contains(neighbor)) {
                    queue.offer(neighbor);
                    oldNodes.add(neighbor);
                }
            }
        }

        for (Node oldNode : oldNodes) {
            Node newNode = mapNewNodes.get(oldNode.val);
            for (Node oldNeighbor : oldNode.neighbors) {
                Node newNeighbor = mapNewNodes.get(oldNeighbor.val);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return mapNewNodes.get(node.val);
    }
}