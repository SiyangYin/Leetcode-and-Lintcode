import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution5 {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(null, null);
        map.put(head, new RandomListNode(head.label));
        Queue<RandomListNode> queue = new LinkedList<>();
        queue.offer(head);
        
        while (!queue.isEmpty()) {
            RandomListNode x = queue.poll();
            if (!map.containsKey(x.next)) {
                map.put(x.next, new RandomListNode(x.next.label));
                queue.offer(x.next);
            }
            map.get(x).next = map.get(x.next);
            if (!map.containsKey(x.random)) {
                map.put(x.random, new RandomListNode(x.random.label));
                queue.offer(x.random);
            }
            map.get(x).random = map.get(x.random);
        }
        
        return map.get(head);
    }
}
