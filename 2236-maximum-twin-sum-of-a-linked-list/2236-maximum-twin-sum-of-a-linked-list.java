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
        if (head == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        // split list into 2 halves
        ListNode first = head;
        ListNode second = head.next;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        if (second == null) {
            throw new IllegalArgumentException("Number of nodes must be even");
        }
        second = first.next;
        first.next = null;

        // reverse second half, and find max twin sum
        ListNode firstPrev = null;
        ListNode secondPrev = null;
        first = head;
        second = reverse(second);
        int maxSum = Integer.MIN_VALUE;
        while (first != null && second != null) {
            maxSum = Math.max(maxSum, first.val + second.val);
            firstPrev = first;
            secondPrev = second;
            first = first.next;
            second = second.next;
        }

        // restore original list
        firstPrev.next = reverse(secondPrev);
        
        return maxSum;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}