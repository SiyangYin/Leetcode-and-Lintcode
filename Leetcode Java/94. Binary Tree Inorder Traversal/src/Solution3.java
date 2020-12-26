import java.util.*;

public class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<Map.Entry<TreeNode, Boolean>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, false));
    
        while (!stack.isEmpty()) {
            Map.Entry<TreeNode, Boolean> x = stack.pop();
//            if (x.getKey() == null) {
//                continue;
//            }
            if (x.getKey() != null && !x.getValue()) {
                stack.push(new AbstractMap.SimpleEntry<>(x.getKey().right, false));
                stack.push(new AbstractMap.SimpleEntry<>(x.getKey(), true));
                stack.push(new AbstractMap.SimpleEntry<>(x.getKey().left, false));
            } else if (x.getKey() != null){
                list.add(x.getKey().val);
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        System.out.println(new Solution().inorderTraversal(root));
    }
}
