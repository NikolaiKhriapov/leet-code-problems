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

        ListNode dummyOddHead = new ListNode(-1);
        ListNode dummyEvenHead = new ListNode(-1);
        
        ListNode dummyOdd = dummyOddHead;
        ListNode dummyEven = dummyEvenHead;

        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                dummyOdd.next = head;
                dummyOdd = dummyOdd.next;
            } else {
                dummyEven.next = head;
                dummyEven = dummyEven.next;
            }
            isOdd = !isOdd;
            head = head.next;
        }

        dummyOdd.next = dummyEvenHead.next;
        dummyEven.next = null;

        return dummyOddHead.next;
    }
}