import java.util.*;

public class Solution2 {
    /**
     * @param root: the root of the tree
     * @return: post order of the tree
     */
    public List<Integer> postorder(UndirectedGraphNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Deque<UndirectedGraphNode> stack = new LinkedList<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            UndirectedGraphNode cur = stack.pop();
            res.add(cur.label);
    
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                stack.push(neighbor);
            }
        }
        
        Collections.reverse(res);
        return res;
    }
}
