import java.util.*;

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        
        if (graph == null) {
            return order;
        }
        
        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        
        for (DirectedGraphNode node : graph) {
            if (indegree.get(node) == 0) {
                queue.offer(node);
                order.add(node);
            }
        }
        
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    order.add(neighbor);
                }
            }
        }
        
        if (order.size() == graph.size()) {
            return order;
        } else {
            return null;
        }
    }
    
    // 统计所有顶点的入度
    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        
        for (DirectedGraphNode node : graph) {
            indegree.put(node, 0);
        }
        
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        
        return indegree;
    }
    
    public static void main(String[] args) {
        DirectedGraphNode head = new DirectedGraphNode(0);
        DirectedGraphNode node1 = new DirectedGraphNode(1);
        // DirectedGraphNode node2 = new DirectedGraphNode(2);
        // DirectedGraphNode node3 = new DirectedGraphNode(3);
        // DirectedGraphNode node4 = new DirectedGraphNode(4);
        // DirectedGraphNode node5 = new DirectedGraphNode(5);
        
        head.neighbors.add(node1);
        head.neighbors.add(node1);
        // head.neighbors.add(node2);
        // head.neighbors.add(node3);
        
        // node1.neighbors.add(node4);
        
        // node2.neighbors.add(node4);
        // node2.neighbors.add(node5);
        
        // node3.neighbors.add(node4);
        // node3.neighbors.add(node5);
        
        ArrayList<DirectedGraphNode> graph = new ArrayList<>(){{
            add(head);
            add(node1);
            // add(node2);
            // add(node3);
            // add(node4);
            // add(node5);
        }};
    
        ArrayList<DirectedGraphNode> list = new Solution().topSort(graph);
        for (DirectedGraphNode node : list) {
            System.out.println(node.label);
        }
    
    }
}

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}