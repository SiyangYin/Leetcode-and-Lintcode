import java.util.*;

public class Solution {
    /*
     * @param graph: a list of Undirected graph nodes
     * @param s: Undirected graph node
     * @param t: Undirected graph node
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        // write your code here
        if (graph == null || graph.isEmpty()) {
            return -1;
        }
        
        if (s == t) {
            return 0;
        }
        
        Queue<UndirectedGraphNode> beginQueue = new LinkedList<>();
        Queue<UndirectedGraphNode> endQueue = new LinkedList<>();
        Set<UndirectedGraphNode> beginSet = new HashSet<>();
        Set<UndirectedGraphNode> endSet = new HashSet<>();
        
        beginQueue.add(s);
        beginSet.add(s);
        endQueue.add(t);
        endSet.add(t);
        
        int step = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginSize = beginQueue.size(), endSize = endQueue.size();
            step++;
            for (int i = 0; i < beginSize; i++) {
                UndirectedGraphNode cur = beginQueue.poll();
                for (UndirectedGraphNode neighbor : cur.neighbors) {
                    if (endSet.contains(neighbor)) {
                        return step;
                    }
                    if (beginSet.add(neighbor)) {
                        beginQueue.offer(neighbor);
                    }
                }
            }
    
            step++;
            for (int i = 0; i < endSize; i++) {
                UndirectedGraphNode cur = endQueue.poll();
                for (UndirectedGraphNode neighbor : cur.neighbors) {
                    if (beginSet.contains(neighbor)) {
                        return step;
                    }
                    if (endSet.add(neighbor)) {
                        endQueue.offer(neighbor);
                    }
                }
            }
            
        }
        
        return -1;
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}