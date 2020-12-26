import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        if (root == null) {
            return res;
        }
        
        stack.push(root);
        while (!stack.isEmpty()) {
            Node x = stack.pop();
            res.add(x.val);
            if (x.children != null) {
                for (int i = x.children.size() - 1; i >= 0; i--) {
                    stack.push(x.children.get(i));
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        System.out.println(root.children);
        root.children = new ArrayList<>();
        root.children.add(new Node(3));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        
        
        System.out.println(new Solution3().preorder(root));
    }
}
