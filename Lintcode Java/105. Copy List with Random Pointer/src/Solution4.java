import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(null, null);
        return copy(head, map);
    }
    
    private RandomListNode copy(RandomListNode head, Map<RandomListNode, RandomListNode> map) {
        if (map.containsKey(head)) {
            return map.get(head);
        }
        
        map.put(head, new RandomListNode(head.label));
        map.get(head).next = copy(head.next, map);
        map.get(head).random = copy(head.random, map);
        return map.get(head);
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
        n4.random = n2;
        n5.random = n2;
        
        new Solution4().copyRandomList(n1);
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) {
        this.label = x;
    }
}