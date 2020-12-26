import java.util.*;

public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // write your code here
        if (graph == null || graph.size() == 0) {
            return null;
        }
        
        if (values.get(node) == target) {
            return node;
        }
        
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
    
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (values.get(neighbor) == target) {
                    return neighbor;
                }
                
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        
        return null;
    }
}

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}