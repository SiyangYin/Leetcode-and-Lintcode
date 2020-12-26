import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        List<Integer> row = new ArrayList<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node x = queue.poll();
                row.add(x.val);
                if (x.children != null) {
                    for (Node child : x.children) {
                        queue.offer(child);
                    }
                }
            }
            res.add(new ArrayList<>(row));
            row.clear();
        }
        
        return res;
    }

}

class Node {
    int val;
    List<Node> children;
    Node() {}
    Node(int _val) {
        val = _val;
    }
    Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}