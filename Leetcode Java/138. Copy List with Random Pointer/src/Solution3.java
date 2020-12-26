public class Solution3 {
    public Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }
        
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        Node dummy = new Node(0), prev = dummy;
        cur = head;
        while (cur != null) {
            prev.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            prev = prev.next;
        }
        
        return dummy.next;
    }
}
