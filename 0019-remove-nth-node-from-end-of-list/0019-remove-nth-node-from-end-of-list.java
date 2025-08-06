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

        int nodesCount = 0;
        ListNode curr = head;
        while (curr != null) {
            nodesCount++;
            curr = curr.next;
        }

        if (nodesCount < n) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        int nodesUntilNodeToDelete = nodesCount - n;
        ListNode dummy = new ListNode(-1, head);
        curr = dummy;
        while (nodesUntilNodeToDelete-- > 0) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return dummy.next;
    }
}

// time  - O(n)
// space - O(1)