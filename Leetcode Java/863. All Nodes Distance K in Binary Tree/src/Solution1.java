import java.util.*;

public class Solution1 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs1(root, map);
        Set<Integer> res = new HashSet<>();
        if (k == 0) {
            res.add(target.val);
        }
        else {
            dfs2(target.val, target.val, map, res, k, 1);
        }
        return new ArrayList<>(res);
    }

    public void dfs1(TreeNode node, Map<Integer, List<Integer>> map) {
        if (node.left != null) {
            List<Integer> list1 = map.getOrDefault(node.val, new ArrayList<>());
            list1.add(node.left.val);
            map.putIfAbsent(node.val, list1);
            List<Integer> list2 = map.getOrDefault(node.left.val, new ArrayList<>());
            list2.add(node.val);
            map.putIfAbsent(node.left.val, list2);
            dfs1(node.left, map);
        }
        if (node.right != null) {
            List<Integer> list1 = map.getOrDefault(node.val, new ArrayList<>());
            list1.add(node.right.val);
            map.putIfAbsent(node.val, list1);
            List<Integer> list2 = map.getOrDefault(node.right.val, new ArrayList<>());
            list2.add(node.val);
            map.putIfAbsent(node.right.val, list2);
            dfs1(node.right, map);
        }
    }

    public void dfs2(int i, int j, Map<Integer, List<Integer>> map, Set<Integer> res, int k, int depth) {
        List<Integer> list = map.getOrDefault(j, new ArrayList<>());
        if (depth == k) {
            res.addAll(list);
            res.remove(i);
        }
        else {
            for (int p : list) {
                if (p != i) {
                    dfs2(j, p, map, res, k, depth + 1);
                }
            }
        }
    }
}

