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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        boolean isOdd = true;
        ListNode curr = even.next;
        while (curr != null) {
            if (isOdd) {
                odd.next = curr;
                odd = odd.next;
            } else {
                even.next = curr;
                even = even.next;
            }
            curr = curr.next;
            isOdd = !isOdd;
        }
        
        even.next = null;
        odd.next = evenHead;

        return head;
    }
}

// time  - O(n)
// space - O(1)