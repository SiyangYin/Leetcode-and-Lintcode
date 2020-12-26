import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {
    /**
     * @param root: the tree
     * @return: pre order of the tree
     */
    public List<Integer> preorder(UndirectedGraphNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Deque<UndirectedGraphNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            UndirectedGraphNode cur = stack.pop();
            res.add(cur.label);
            while (!cur.neighbors.isEmpty()) {
                for (int i = cur.neighbors.size() - 1; i > 0; i--) {
                    stack.push(cur.neighbors.get(i));
                }
                cur = cur.neighbors.get(0);
                res.add(cur.label);
            }
        }
        
        return res;
    }
}
