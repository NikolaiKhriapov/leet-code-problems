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

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = reverseList(slow.next);
        slow.next = null;

        return findMaxPairSum(head, second);
    }

    private static ListNode reverseList(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    private static int findMaxPairSum(ListNode list1, ListNode list2) {
        int maxPairSum = Integer.MIN_VALUE;
        while (list1 != null && list2 != null) {
            maxPairSum = Math.max(maxPairSum, list1.val + list2.val);
            list1 = list1.next;
            list2 = list2.next;
        }
        return maxPairSum;
    }
}