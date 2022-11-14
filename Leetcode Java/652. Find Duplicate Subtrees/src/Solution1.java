import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    private Map<TreeNode, String> map1 = new HashMap<>();
    private Map<String, Integer> map2 = new HashMap<>();
    private List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    public String preOrder(TreeNode node) {
        if (map1.containsKey(node)) {
            return map1.get(node);
        }
        if (node == null) {
            map1.put(node, "#");
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append(",");
        sb.append(preOrder(node.left)).append(",");
        sb.append(preOrder(node.right));
        map1.put(node, sb.toString());
        return sb.toString();
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            String s = preOrder(node);
            if (!map2.containsKey(s)) {
                map2.put(s, 1);
            }
            else if (map2.get(s) == 1) {
                res.add(node);
                map2.put(s, 2);
            }
            dfs(node.left);
            dfs(node.right);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        List<TreeNode> list = new Solution1().findDuplicateSubtrees(root);
        System.out.println(list);
    }
}

