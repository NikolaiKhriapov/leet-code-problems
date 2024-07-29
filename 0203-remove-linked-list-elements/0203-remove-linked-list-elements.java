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

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (curr.val != val) {
                prev = curr;
                curr = curr.next;
            } else {
                if (prev != null) {
                    ListNode next = curr.next;
                    prev.next = next;
                    curr.next = null;
                    curr = next;
                } else {
                    head = curr.next;
                    curr = head;
                }
            }
        }
        
        return head;
    }
}