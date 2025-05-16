/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            Node temp = curr.next;
            copy.next = temp;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node dummyHead = new Node(0);
        Node dummy = dummyHead;
        curr = head;
        while (curr != null) {
            dummy.next = curr.next;
            dummy = dummy.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }
        
        return dummyHead.next;
    }
}