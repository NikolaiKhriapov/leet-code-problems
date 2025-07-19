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
    public int pairSum(ListNode head) {
        if (head == null || head.next == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        ListNode first = head;
        ListNode second = head.next;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        if (second == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        second = reverseList(first.next);
        first.next = null;
        first = head;
        
        int maxTwinSum = 0;
        while (first != null || second != null) {
            maxTwinSum = Math.max(maxTwinSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return maxTwinSum;
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