import java.util.*;

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(List<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if (s == t) {
            return true;
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Set<DirectedGraphNode> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        
        while (!queue.isEmpty()) {
            DirectedGraphNode begin = queue.poll();
            for (DirectedGraphNode neighbor : begin.neighbors) {
                if (neighbor == t) {
                    return true;
                }
                
                if (visited.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return false;
    }
}

class DirectedGraphNode {
    int label;
    List<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}