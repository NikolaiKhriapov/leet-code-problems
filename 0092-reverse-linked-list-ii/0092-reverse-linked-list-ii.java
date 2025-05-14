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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;

        int count = 1;
        while (count < left) {
            curr = curr.next;
            count++;
        }
        
        ListNode midHead = curr.next;
        ListNode mid = midHead;
        ListNode prev = null;
        while (count <= right) {
            ListNode temp = mid.next;
            mid.next = prev;
            prev = mid;
            mid = temp;
            count++;
        }
        curr.next = prev;
        midHead.next = mid;

        return dummy.next;
    }
}