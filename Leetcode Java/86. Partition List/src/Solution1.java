public class Solution1 {

    public ListNode partition(ListNode head, int x) {
        ListNode p0 = new ListNode();
        p0.next = head;
        ListNode p1 = p0;
        while (p1.next != null && p1.next.val < x) p1 = p1.next;
        ListNode p2 = p1;
        while (p2 != null && p2.next != null) {
            if (p2.next.val < x) {
                ListNode node = remove(p2);
                insert(p1, node);
                p1 = p1.next;
            }
            else {
                p2 = p2.next;
            }
        }
        return p0.next;
    }

    public void insert(ListNode n1, ListNode n2) {
        n2.next = n1.next;
        n1.next = n2;
    }

    public ListNode remove(ListNode n1) {
        ListNode n2 = n1.next;
        n1.next = n2.next;
        return n2;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        // head.next.next.next.next = new ListNode(5);
        // head.next.next.next.next.next = new ListNode(2);
        
        head = null;
        head = new Solution1().partition(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

