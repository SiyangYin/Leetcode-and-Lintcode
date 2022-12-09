import java.util.*;

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> parent = new HashSet<>();
        Set<Integer> child = new HashSet<>();
        for (int[] i : descriptions) {
            parent.add(i[0]);
            child.add(i[1]);
            TreeNode node = map.getOrDefault(i[0], new TreeNode(i[0]));
            if (i[2] == 1) {
                node.left = map.getOrDefault(i[1], new TreeNode(i[1]));
                map.putIfAbsent(i[1], node.left);
            }
            else {
                node.right = map.getOrDefault(i[1], new TreeNode(i[1]));
                map.putIfAbsent(i[1], node.right);
            }
            map.putIfAbsent(i[0], node);
        }
        for (int i : parent) {
            if (!child.contains(i)) {
                return map.get(i);
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().createBinaryTree(new int[][]{{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}}).val);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}