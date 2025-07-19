/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tailA = headA;
        ListNode tailB = headB;
        while (tailA != tailB) {
            tailA = (tailA == null) ? headB : tailA.next;
            tailB = (tailB == null) ? headA : tailB.next;
        }
        return tailA;
    }
}

// time  - O(n)
// space - O(1)