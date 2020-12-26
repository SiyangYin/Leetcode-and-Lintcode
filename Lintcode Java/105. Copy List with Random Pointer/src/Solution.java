import java.util.HashMap;

public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        
        // the new head
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        
        while (head != null) {
            
            if (!map.containsKey(head)) {
                cur.next = new RandomListNode(head.label);
                map.put(head, cur.next);
                
            } else {
                cur.next = map.get(head);
            }
            
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    cur.next.random = new RandomListNode(head.random.label);
                    map.put(head.random, cur.next.random);
                } else {
                    cur.next.random = map.get(head.random);
                }
            }
            head = head.next;
            cur = cur.next;
        }
        
        return dummy.next;
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
        
        RandomListNode newHead = new Solution().copyRandomList(n1);
        
        RandomListNode head = newHead;
        while (head != null) {
            System.out.println(head.random.label);
            head = head.next;
        }
        
    }
}

