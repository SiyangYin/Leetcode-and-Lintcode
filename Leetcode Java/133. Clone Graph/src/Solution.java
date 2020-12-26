import java.util.*;

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        map.put(node, new Node(node.val, new ArrayList<>()));
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
    
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        
        Node newNode = new Solution().cloneGraph(node1);
        System.out.println(newNode.neighbors);
    }
}

class Node {
    int val;
    List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}