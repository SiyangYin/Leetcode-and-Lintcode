import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                res.add(list1.get(i++));
            }
            else {
                res.add(list2.get(j++));
            }
        }
        while (i < list1.size()) {
            res.add(list1.get(i++));
        }
        while (j < list2.size()) {
            res.add(list2.get(j++));
        }
        return res;
    }

    public void dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            dfs(node.left, list);
            list.add(node.val);
            dfs(node.right, list);
        }
    }
    
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(2);
        r1.left = new TreeNode(1);
        r1.right = new TreeNode(4);
        
        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(0);
        r2.right = new TreeNode(3);
        
        System.out.println(new Solution1().getAllElements(r1, r2));
    }
}

