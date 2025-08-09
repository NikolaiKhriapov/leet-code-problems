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
        if (left > right || left < 1) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode leftTail = null;
        ListNode midHead = dummy;

        for (int i = 0; i < left; i++) {
            leftTail = midHead;
            midHead = midHead.next;
        }
        
        ListNode midTail = midHead;
        for (int i = left; i < right; i++) {
            midTail = midTail.next;
        }
        
        ListNode rightHead = midTail.next;
        midTail.next = null;
        ListNode midHeadNew = reverseList(midHead);
        leftTail.next = midHeadNew;
        midHead.next = rightHead;

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}

// time  - O(n)
// space - O(1)