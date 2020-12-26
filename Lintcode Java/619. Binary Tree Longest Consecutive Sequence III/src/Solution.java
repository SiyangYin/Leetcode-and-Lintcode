import java.util.List;

public class Solution {
    
    private int res;
    
    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        dfs(root);
        return res;
    }
    
    private int[] dfs(MultiTreeNode cur) {
        if (cur == null) {
            return null;
        }
        
        int incLen = 1, decLen = 1;
        for (MultiTreeNode child : cur.children) {
            if (child != null) {
                int[] len = dfs(child);
                if (child.val == cur.val + 1) {
                    incLen = Math.max(incLen, 1 + len[0]);
                }
                if (child.val == cur.val - 1) {
                    decLen = Math.max(decLen, 1 + len[1]);
                }
            }
        }
        
        res = Math.max(res, incLen + decLen - 1);
        
        return new int[]{incLen, decLen};
    }
}

class MultiTreeNode {
    int val;
    List<MultiTreeNode> children;
    
    public MultiTreeNode(int val) {
        this.val = val;
    }
}