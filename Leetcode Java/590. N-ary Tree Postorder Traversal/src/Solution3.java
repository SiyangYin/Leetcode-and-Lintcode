import java.util.*;

public class Solution3 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node x = stack.pop();
            res.add(x.val);
            for (Node child : x.children) {
                stack.push(child);
            }
        }
    
        Collections.reverse(res);
        return res;
    }
    
    public static void main(String[] args) {
        // Node root = new Node(1);
        // System.out.println(root.children);
        // root.children = new ArrayList<>();
        // root.children.add(new Node(3));
        // root.children.get(0).children = new ArrayList<>();
        // root.children.get(0).children.add(new Node(5));
        // root.children.get(0).children.add(new Node(6));
        // root.children.add(new Node(2));
        // root.children.add(new Node(4));
        //
        //
        // System.out.println(new Solution3().postorder(root));
    }
}
