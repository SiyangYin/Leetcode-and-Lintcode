import java.util.*;

public class Solution1 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<TreeNode, List<Integer>> map = new HashMap<>();
        dfs(root, map, 0, 0);
        List<TreeNode> list = new ArrayList<>(map.keySet());
        list.sort((i1, i2) -> {
            if (map.get(i1).get(1) - map.get(i2).get(1) != 0) {
                return map.get(i1).get(1) - map.get(i2).get(1);
            }
            else {
                if (map.get(i1).get(0) - map.get(i2).get(0) != 0) {
                    return map.get(i1).get(0) - map.get(i2).get(0);
                }
                else {
                    return i1.val - i2.val;
                }
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(list.get(0).val);
        res.add(l);
        for (int i = 1; i < list.size(); i++) {
            if (map.get(list.get(i)).get(1) != map.get(list.get(i - 1)).get(1)) {
                l = new ArrayList<>();
                l.add(list.get(i).val);
                res.add(l);
            }
            else {
                res.get(res.size() - 1).add(list.get(i).val);
            }
        }
        return res;
    }

    public void dfs(TreeNode node, Map<TreeNode, List<Integer>> map, int row, int col) {
        if (node != null) {
            map.put(node, Arrays.asList(row, col));
            dfs(node.left, map, row + 1, col - 1);
            dfs(node.right, map, row + 1, col + 1);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution1().verticalTraversal(root));
    }
}

