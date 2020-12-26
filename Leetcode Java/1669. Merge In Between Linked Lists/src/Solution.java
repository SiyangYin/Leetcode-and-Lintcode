public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = list1;
    
        for (int i = 0; i < a; i++) {
            prev = prev.next;
        }
        
        ListNode next = prev;
        for (int i = 0; i < b - a + 2; i++) {
            next = next.next;
        }
        
        prev.next = list2;
        while (prev.next != null) {
            prev = prev.next;
        }
        
        prev.next = next;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}