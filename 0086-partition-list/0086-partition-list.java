class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head; 
        
        ListNode chota = new ListNode(0);
        ListNode bara = new ListNode(0);
        ListNode chotaD = chota;
        ListNode baraD = bara;
        
        ListNode curr = head; 
        
        while (curr != null) {
            if (curr.val < x) {
                chotaD.next = curr;
                chotaD = chotaD.next;
            } else {
                baraD.next = curr;
                baraD = baraD.next;
            }
            curr = curr.next;
        }
        
        baraD.next = null;
        chotaD.next = bara.next;
        
        return chota.next;
    }
}
