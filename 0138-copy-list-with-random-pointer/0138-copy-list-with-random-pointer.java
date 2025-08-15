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

        Node newHead = new Node(head.val);

        Map<Node, Node> mapOldToNew = new HashMap<>();
        mapOldToNew.put(head, newHead);
        
        Node curr = head;
        Node newCurr = newHead;
        while (curr.next != null) {
            newCurr.next = new Node(curr.next.val);
            curr = curr.next;
            newCurr = newCurr.next;
            mapOldToNew.put(curr, newCurr);
        }

        curr = head;
        while (curr != null) {
            mapOldToNew.get(curr).random = mapOldToNew.get(curr.random);
            curr = curr.next;
        }

        return newHead;
    }
}

// time  - O(n)
// space - O(n)