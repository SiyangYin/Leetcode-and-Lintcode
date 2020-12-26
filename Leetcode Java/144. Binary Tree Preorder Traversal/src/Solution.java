import java.util.*;

public class Solution {
    
    class Pair {
        TreeNode node;
        boolean visited;
        Pair(TreeNode node, boolean visited) {
            this.node = node;
            this.visited = visited;
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(root, false));
        
        while (!stack.isEmpty()) {
            Pair x = stack.pop();
            if (!x.visited) {
                x.visited = true;
                stack.push(x);
            } else {
                list.add(x.node.val);
                if (x.node.right != null) {
                    stack.push(new Pair(x.node.right, false));
                }
                if (x.node.left != null) {
                    stack.push(new Pair(x.node.left, false));
                }
            }
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
    
        System.out.println(new Solution().preorderTraversal(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

