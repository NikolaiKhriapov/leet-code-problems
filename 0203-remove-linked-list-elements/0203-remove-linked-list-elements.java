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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                if (prev == null) {
                    curr = curr.next;
                    head = curr;
                } else {
                    curr = curr.next;
                    prev.next = curr;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;        
    }
}