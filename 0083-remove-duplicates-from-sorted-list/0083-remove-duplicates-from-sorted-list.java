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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            if (prev == null) {
                head = curr;
                prev = curr;
                curr = curr.next;
            } else {
                if (curr.val == prev.val) {
                    curr = curr.next;
                    prev.next = curr;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        
        return head;
    }
}