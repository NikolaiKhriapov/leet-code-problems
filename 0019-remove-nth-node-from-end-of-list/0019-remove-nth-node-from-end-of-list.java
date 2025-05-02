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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr1 = dummy;
        ListNode curr2 = dummy;

        while (n > 0) {
            curr1 = curr1.next;
            n--;
        }
        while (curr1.next != null) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        curr2.next = curr2.next.next;

        return dummy.next;
    }
}