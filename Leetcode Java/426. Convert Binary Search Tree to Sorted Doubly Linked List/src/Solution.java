import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        
        Node dummy = new Node(0), cur = dummy;
        
        Deque<Node> stack = new LinkedList<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            
            node = stack.pop();
            cur.right = node;
            node.left = cur;
            cur = cur.right;
            
            node = node.right;
        }
        
        cur.right = dummy.right;
        dummy.right.left = cur;
        
        return dummy.right;
    }
    
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
    
        Node node = new Solution().treeToDoublyList(root);
        System.out.println();
    }
}

class Node {
    int val;
    Node left, right;
    
    public Node(int val) {
        this.val = val;
    }
}