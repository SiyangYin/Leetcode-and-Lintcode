import java.util.*;

public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nodes == null || nodes.isEmpty()) {
            return res;
        }
    
        Set<UndirectedGraphNode> visited = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            if (!visited.contains(node)) {
                res.add(bfs(nodes, node, visited));
            }
        }
        
        return res;
    }
    
    private List<Integer> bfs(List<UndirectedGraphNode> nodes, UndirectedGraphNode node, Set<UndirectedGraphNode> visited) {
        List<Integer> comp = new ArrayList<>();
        comp.add(node.label);
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!visited.contains(neighbor)) {
                    comp.add(neighbor.label);
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        Collections.sort(comp);
        return comp;
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