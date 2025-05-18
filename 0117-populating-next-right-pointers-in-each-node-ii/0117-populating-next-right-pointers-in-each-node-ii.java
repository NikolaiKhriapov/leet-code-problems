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
            return null;
        }

        Node curr = root;
        while (curr != null) {
            Node dummyHead = new Node(0);
            Node dummy = dummyHead;
            while (curr != null) {
                if (curr.left != null) {
                    dummy.next = curr.left;
                    dummy = dummy.next;
                }
                if (curr.right != null) {
                    dummy.next = curr.right;
                    dummy = dummy.next;
                }
                curr = curr.next;
            }
            curr = dummyHead.next;
        }
        return root;
    }
}