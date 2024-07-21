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
    public boolean isPalindrome(ListNode head) {
        
        List<Integer> list = new ArrayList<>();

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        list.add(curr.val);

        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (list.get(i) != list.get(size - i - 1)) {
                return false;
            }
        }

        return true;
    }
}