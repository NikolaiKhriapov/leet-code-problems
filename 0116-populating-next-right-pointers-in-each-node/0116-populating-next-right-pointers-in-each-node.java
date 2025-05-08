/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        helper(root, null);
        return root;
    }

    private void helper(Node node, Node next) {
        if (node == null) return;

        node.next = next;
        helper(node.left, node.right);
        helper(node.right, next != null ? next.left : null);
    }
}