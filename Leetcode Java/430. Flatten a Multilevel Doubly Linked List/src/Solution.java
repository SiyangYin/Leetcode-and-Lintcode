public class Solution {
    public Node flatten(Node head) {
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node flatten = flatten(cur.child);
                Node flattenCur = flatten;
                while (flattenCur.next != null) {
                    flattenCur = flattenCur.next;
                }
                
                flattenCur.next = cur.next;
                if (flattenCur.next != null) {
                    flattenCur.next.prev = flattenCur;
                }
                
                cur.next = flatten;
                cur.next.prev = cur;
                cur.child = null;
                cur = flattenCur.next;
            } else {
                cur = cur.next;
            }
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        
        head.next.child = new Node(7);
        head.next.child.next = new Node(8);
        head.next.child.next.prev = head.next.child;
    
        Node hh = new Solution().flatten(head);
        System.out.println(hh);
    }
}

class Node {
    int val;
    Node prev, next, child;
    
    public Node(int val) {
        this.val = val;
    }
}