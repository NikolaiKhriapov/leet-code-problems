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
        ListNode headSaved = head;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                if (head.next.next != null) {
                    head.next = head.next.next;
                } else {
                    head.next = null;
                }
            } else {
                head = head.next;
            }
        }

        return headSaved;
    }
}