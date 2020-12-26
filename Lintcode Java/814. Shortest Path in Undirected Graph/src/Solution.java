import java.util.*;

public class Solution {
    /**
     * @param graph: a list of Undirected graph node
     * @param A: nodeA
     * @param B: nodeB
     * @return:  the length of the shortest path
     */
    public int shortestPath(List<UndirectedGraphNode> graph, UndirectedGraphNode A, UndirectedGraphNode B) {
        // Write your code here
        if (A == B) {
            return 0;
        }
        
        Queue<UndirectedGraphNode> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        Set<UndirectedGraphNode> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginQueue.offer(A);
        beginSet.add(A);
        endQueue.offer(B);
        endSet.add(B);
        
        int res = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginSize = beginQueue.size(), endSize = endQueue.size();
            res++;
            for (int i = 0; i < beginSize; i++) {
                UndirectedGraphNode cur = beginQueue.poll();
                for (UndirectedGraphNode neighbor : cur.neighbors) {
                    if (endSet.contains(neighbor)) {
                        return res;
                    }
                    if (beginSet.add(neighbor)) {
                        beginQueue.offer(neighbor);
                    }
                }
            }
            res++;
            for (int i = 0; i < endSize; i++) {
                UndirectedGraphNode cur = endQueue.poll();
                for (UndirectedGraphNode neighbor : cur.neighbors) {
                    if (beginSet.contains(neighbor)) {
                        return res;
                    }
                    if (endSet.add(neighbor)) {
                        endQueue.offer(neighbor);
                    }
                }
            }
        }
        
        return Integer.MAX_VALUE;
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}