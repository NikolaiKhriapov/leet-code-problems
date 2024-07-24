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
    public ListNode middleNode(ListNode head) {
        
        int counter = 0;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null) curr = curr.next;
            else curr = null;
            counter++;
        }

        int mid = counter / 2;
        while (mid-- > 0) {
            head = head.next;
        }
        
        return head;
    }
}