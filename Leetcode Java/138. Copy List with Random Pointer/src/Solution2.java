import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        map.put(head, new Node(head.val));
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.next != null && !map.containsKey(cur.next)) {
                map.put(cur.next, new Node(cur.next.val));
                queue.offer(cur.next);
            }
            map.get(cur).next = map.get(cur.next);
            if (cur.random != null && !map.containsKey(cur.random)) {
                map.put(cur.random, new Node(cur.random.val));
                queue.offer(cur.random);
            }
            map.get(cur).random = map.get(cur.random);
        }
        
        return map.get(head);
    }
}
