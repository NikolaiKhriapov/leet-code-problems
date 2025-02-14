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
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;        
    }

    private void helper(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        for (Node child : node.children) {
            helper(child, list);
        }
        list.add(node.val);
    }
}