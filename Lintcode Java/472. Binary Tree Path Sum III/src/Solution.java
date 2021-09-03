import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs1(root, new ArrayList<>(), res, target);
        return res;
    }
    
    void dfs1(ParentTreeNode cur, List<Integer> list, List<List<Integer>> res, int target) {
        if (cur == null) {
            return;
        }
        
        dfs2(cur, cur, 0, list, res, target);
        dfs1(cur.left, list, res, target);
        dfs1(cur.right, list, res, target);
    }
    
    void dfs2(ParentTreeNode cur, ParentTreeNode from, int sum, List<Integer> list, List<List<Integer>> res, int target) {
        if (cur == null) {
            return;
        }
        
        sum += cur.val;
        list.add(cur.val);
        if (sum == target) {
            res.add(new ArrayList<>(list));
        }
        
        if (cur.left != from) {
            dfs2(cur.left, cur, sum, list, res, target);
        }
        if (cur.right != from) {
            dfs2(cur.right, cur, sum, list, res, target);
        }
        if (cur.parent != from) {
            dfs2(cur.parent, cur, sum, list, res, target);
        }
        
        list.remove(list.size() - 1);
    }
    
    public static void main(String[] args) {
        ParentTreeNode root = new ParentTreeNode(1);
        root.left = new ParentTreeNode(2);
        root.left.parent = root;
        root.left.left = new ParentTreeNode(4);
        root.left.left.parent = root.left;
        root.right = new ParentTreeNode(3);
        root.right.parent = root;
        
        System.out.println(new Solution().binaryTreePathSum3(root, 6));
    }
}

class ParentTreeNode {
    int val;
    ParentTreeNode parent, left, right;
    
    public ParentTreeNode(int val) {
        this.val = val;
    }
}