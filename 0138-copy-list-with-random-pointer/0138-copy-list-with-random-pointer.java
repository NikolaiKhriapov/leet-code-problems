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
        Node oldNode = head;
        while (oldNode != null) {
            map.put(oldNode, new Node(oldNode.val));
            oldNode = oldNode.next;
        }

        oldNode = head;
        while (oldNode != null) {
            Node newNode = map.get(oldNode);
            newNode.next = map.get(oldNode.next);
            newNode.random = map.get(oldNode.random);
            oldNode = oldNode.next;
        }
        
        return map.get(head);
    }
}