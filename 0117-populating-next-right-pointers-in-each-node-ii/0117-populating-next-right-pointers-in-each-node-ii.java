class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
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