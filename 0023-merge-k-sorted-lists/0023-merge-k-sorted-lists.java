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
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode();
        ListNode dummyTail = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            dummyTail.next = min;
            dummyTail = dummyTail.next;
            if (min.next != null) {
                pq.add(min.next);
            }
        }

        return dummy.next;
    }
}