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
            if (head.next != null) head = head.next;
            else head = null;
        }

        String s = sb.toString();

        return convertBinaryToDecimal(s);
    }

    public int convertBinaryToDecimal(String s) {
        int result = 0;
        for (int i = 0, size = s.length(); i < size; i++) {
            char c = s.charAt(size - 1 - i);
            if (c == '1') {
                result += Math.pow(2, i);
            }
        }
        return result;
    }
}