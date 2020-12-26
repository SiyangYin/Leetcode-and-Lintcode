public class Solution2 {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        duplicate(head);
        RandomListNode cur = head;
        
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        cur = head.next;
        RandomListNode oldHead = head;
        RandomListNode newHead = cur;
        while (cur.next != null) {
            oldHead.next = oldHead.next.next;
            oldHead = oldHead.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        oldHead.next = oldHead.next.next;
        return newHead;
        
    }
    
    private void duplicate(RandomListNode head) {
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }
    }
    
    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
        n1.random = n3;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n2;
        
        n1 = new RandomListNode(-1);
        
        RandomListNode newHead = new Solution2().copyRandomList(n1);
        
        RandomListNode head = newHead;
        while (head != null) {
            System.out.println(head.label);
            head = head.next;
        }
        
        RandomListNode cur = n1;
        while (cur != null) {
            System.out.println(cur.label);
            cur = cur.next;
        }
        
    }
}
