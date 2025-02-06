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
        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != null || pb != null) {
            if (pa == pb) {
                return pa;
            }

            if (pa != null) {
                pa = pa.next;
            } else {
                pa = headB;
            }

            if (pb != null) {
                pb = pb.next;
            } else {
                pb = headA;
            }
        }
        
        return null;
    }
}