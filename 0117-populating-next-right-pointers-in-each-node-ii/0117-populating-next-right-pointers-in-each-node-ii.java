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
        if (root == null) {
            return root;
        }

        Node curr = root;
        while (curr != null) {
            Node dummy = new Node(0);
            Node dummyCurr = dummy;
            while (curr != null) {
                if (curr.left != null) {
                    dummyCurr.next = curr.left;
                    dummyCurr = dummyCurr.next;
                }
                if (curr.right != null) {
                    dummyCurr.next = curr.right;
                    dummyCurr = dummyCurr.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }
}