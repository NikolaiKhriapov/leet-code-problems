class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = list1;
        ListNode prev = null;

        while (list2 != null) {
            ListNode curr = list2;
            
            while (list1 != null && curr.val > list1.val) {
                prev = list1;
                if (list1.next != null) list1 = list1.next;
                else {
                    list1.next = list2;
                    return head;
                }
            }

            if (prev == null) head = list2;
            if (list2.next != null) list2 = curr.next;
            else list2 = null;

            curr.next = list1;
            if (prev != null) prev.next = curr;
            prev = curr;
            list1 = curr.next;
        }

        return head;
    }
}