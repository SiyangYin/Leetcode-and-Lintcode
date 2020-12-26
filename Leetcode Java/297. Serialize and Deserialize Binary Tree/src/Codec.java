import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    sb.append(cur.val).append(',');
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else {
                    sb.append('#').append(',');
                }
            }
        }
        
        while (sb.charAt(sb.length() - 2) == '#') {
            sb.setLength(sb.length() - 2);
        }
        
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        
        String[] values = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        
        TreeNode cur = null;
        for (int i = 1; i < values.length; i++) {
            if (i % 2 != 0) {
                cur = queue.poll();
            }
            
            String curs = values[i];
            if (i % 2 != 0 && !curs.equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(curs));
                queue.offer(cur.left);
            } else if (i % 2 == 0 && !curs.equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(curs));
                queue.offer(cur.right);
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        System.out.println(new Codec().serialize(root));
        String haha = new Codec().serialize(root);
        TreeNode ans = new Codec().deserialize(haha);
        System.out.println(ans.val);
        System.out.println(ans.left.val);
        System.out.println(ans.left.left);
        System.out.println(ans.right.val);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}