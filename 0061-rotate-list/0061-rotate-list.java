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
    public ListNode rotateRight(ListNode head, int k) {

        ListNode temp = head;
        int count = 1;
        while (temp != null && temp.next != null) {
            count++;
            temp = temp.next;
        }
        k %= count;

        ListNode dummy = new ListNode(0, head);

        ListNode fast = dummy;
        ListNode slow = dummy;
        
        while (k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode curr = dummy;
        curr.next = slow.next;
        slow.next = null;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;

        return dummy.next;
    }
}