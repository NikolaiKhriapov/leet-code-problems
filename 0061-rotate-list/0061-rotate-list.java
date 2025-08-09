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
        if (k < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int nodesCount = 0;
        ListNode temp = head;
        while (temp != null) {
            nodesCount++;
            temp = temp.next;
        }
        
        k %= nodesCount;
        if (k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode first = head;
        ListNode second = head;

        while (k-- > 0) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        dummy.next = second.next;
        second.next = null;
        first.next = head;
        
        return dummy.next;
    }
}

// time  - O(n)
// space - O(1)