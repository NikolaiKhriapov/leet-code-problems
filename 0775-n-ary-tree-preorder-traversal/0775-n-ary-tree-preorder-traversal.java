/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        handleNode(root, list);
        return list;
    }

    private void handleNode(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            for (Node child : node.children) {
                handleNode(child, list);
            }
        }
    }
}