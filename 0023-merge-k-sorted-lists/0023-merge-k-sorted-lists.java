/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            while (node != null) {
                pq.add(node);
                node = node.next;
            }
        }

        ListNode dummyHead = new ListNode();
        ListNode dummy = dummyHead;
        while (!pq.isEmpty()) {
            dummy.next = pq.poll();
            dummy = dummy.next;
        }
        dummy.next = null;

        return dummyHead.next;
    }
}