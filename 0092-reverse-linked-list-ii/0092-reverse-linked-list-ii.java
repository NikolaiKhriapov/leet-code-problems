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

        ListNode dummy = new ListNode(0, head);
        ListNode listLeft = dummy;
        
        int count = 1;
        while (count < left) {
            listLeft = listLeft.next;
            count++;
        }
        
        ListNode prev = null;
        ListNode listMid = listLeft.next;
        ListNode listMidTail = listMid;

        while (count <= right) {
            ListNode temp = listMid.next;
            listMid.next = prev;
            prev = listMid;
            listMid = temp;
            count++;
        }
        
        listLeft.next = prev;
        listMidTail.next = listMid;

        return dummy.next;
    }
}