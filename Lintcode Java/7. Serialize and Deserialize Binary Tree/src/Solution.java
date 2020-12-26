import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = queue.poll();
                if (x != null) {
                    sb.append(x.val);
                    queue.offer(x.left);
                    queue.offer(x.right);
                } else {
                    sb.append('#');
                }
                sb.append(',');
            }
        }
        
        int i = sb.length() - 1;
        while (sb.charAt(i) == ',' || sb.charAt(i) == '#') {
            i--;
        }
        sb.setLength(i + 1);
        sb.append('}');
        
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        TreeNode root = null;
        if ("{}".equals(data)) {
            return root;
        }
        
        String[] split = data.substring(1, data.length() - 1).split(",");
        root = new TreeNode(Integer.parseInt(split[0]));
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        for (int i = 1; i < split.length; i++) {
            String cur = split[i];
            TreeNode x = queue.peek();
            if (i % 2 != 0 && !"#".equals(cur)) {
                x.left = new TreeNode(Integer.parseInt(cur));
                queue.offer(x.left);
            } else if (i % 2 == 0 && !"#".equals(cur)){
                x.right = new TreeNode(Integer.parseInt(cur));
                queue.offer(x.right);
            }
            
            if (i % 2 == 0) {
                queue.poll();
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        // root = new TreeNode(1);
        
        String res = new Solution().serialize(root);
        System.out.println(res);
        
        TreeNode res1 = new Solution().deserialize(res);
        System.out.println(check(root, res1));
    }
    
    private static boolean check(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        }
        return r1.val == r2.val && check(r1.left, r2.left) && check(r1.right, r2.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}