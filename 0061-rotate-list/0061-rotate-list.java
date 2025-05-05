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
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        ListNode temp = head;
        int listLength = 1;
        while (temp != null && temp.next != null) {
            listLength++;
            temp = temp.next;
        }
        k %= listLength;

        if (k == 0) {
            return head;
        }

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
        fast.next = head;

        return dummy.next;
    }
}