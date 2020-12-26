import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param root: the root of the tree
     * @return: post order of the tree
     */
    public List<Integer> postorder(UndirectedGraphNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    
    private void dfs(UndirectedGraphNode cur, List<Integer> res) {
        for (UndirectedGraphNode neighbor : cur.neighbors) {
            dfs(neighbor, res);
        }
        
        res.add(cur.label);
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    
    public UndirectedGraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }
}