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
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        String s = sb.toString();
        
        int sum = 0;
        int p = s.length() - 1;

        while (p >= 0) {
            int v = (s.charAt(p) == '1') ? ((int) Math.pow(2, s.length() - 1 - p)) : 0;
            sum += v;
            p--;
        }

        return sum;
    }
}