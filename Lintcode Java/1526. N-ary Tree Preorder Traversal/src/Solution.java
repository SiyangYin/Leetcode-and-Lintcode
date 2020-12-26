import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param root: the tree
     * @return: pre order of the tree
     */
    public List<Integer> preorder(UndirectedGraphNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    
    private void dfs(UndirectedGraphNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        res.add(root.label);
        for (UndirectedGraphNode neighbor : root.neighbors) {
            dfs(neighbor, res);
        }
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