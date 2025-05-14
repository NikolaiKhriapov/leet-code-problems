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

        Map<Node, Node> map = new HashMap<>();

        Node newHead = new Node(head.val);
        Node newCurr = newHead;
        Node oldCurr = head;
        while (oldCurr != null) {
            map.put(oldCurr, newCurr);
            newCurr.next = null;
            if (oldCurr.next != null) {
                newCurr.next = new Node(oldCurr.next.val);
            }
            newCurr = newCurr.next;
            oldCurr = oldCurr.next;
        }

        newCurr = newHead;
        oldCurr = head;
        while (oldCurr != null) {
            if (oldCurr.random != null) {
                newCurr.random = map.get(oldCurr.random);
            }
            newCurr = newCurr.next;
            oldCurr = oldCurr.next;
        }

        return newHead;        
    }
}