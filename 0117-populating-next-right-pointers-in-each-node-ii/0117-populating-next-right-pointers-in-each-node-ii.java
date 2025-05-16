class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node curr = root;
        while (curr != null) {
            Node dummy = new Node(0);
            Node dummyTail = dummy;
            while (curr != null) {
                if (curr.left != null) {
                    dummyTail.next = curr.left;
                    dummyTail = dummyTail.next;
                }
                if (curr.right != null) {
                    dummyTail.next = curr.right;
                    dummyTail = dummyTail.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }
}