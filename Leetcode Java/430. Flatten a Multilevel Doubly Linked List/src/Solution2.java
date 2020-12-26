public class Solution2 {
    public Node flatten(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        dfs(dummy.next);
        return dummy.next;
    }
    
    private Node dfs(Node head) {
        Node cur = head, res = cur;
        while (cur != null) {
            if (cur.child != null) {
                Node tail = dfs(cur.child);
                tail.next = cur.next;
                if (tail.next != null) {
                    tail.next.prev = tail;
                }
                cur.next = cur.child;
                cur.next.prev = cur;
                
                cur.child = null;
                cur = tail;
            }
            
            res = cur;
            cur = cur.next;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.child = new Node(4);
        head.next.child.next = new Node(5);
        head.next.child.next.prev = head.next.child;
        new Solution2().flatten(head);
    
        System.out.println();
    }
}
