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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode first = head;
        ListNode second = dummy;
        
        int nodesCount = 0;
        while (first != null) {
            nodesCount++;
            first = first.next;
            if (nodesCount > n) {
                second = second.next;
            }
        }
        second.next = second.next.next;

        return dummy.next;
    }
}

// time  - O(n)
// space - O(1)