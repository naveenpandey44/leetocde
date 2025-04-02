class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode curr = head;
        int carry = 0;
        ListNode dummynode = new ListNode(-1); 
        ListNode temp = dummynode;

        while (curr != null) {
            int val = (curr.val * 2) + carry;
            temp.next = new ListNode(val % 10);
            temp = temp.next;
            carry = val / 10;
            curr = curr.next;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry); 
        }

        return reverse(dummynode.next); 
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
