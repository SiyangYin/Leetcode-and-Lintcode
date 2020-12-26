import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(List<DirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<>();
        if (nodes == null || nodes.isEmpty()) {
            return res;
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        queue.offer(nodes.get(0));
        
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                DirectedGraphNode cur = queue.poll();
                row.add(cur.label);
                for (DirectedGraphNode neighbor : cur.neighbors) {
                    queue.offer(neighbor);
                }
            }
            
            res.add(row);
        }
        
        return res;
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