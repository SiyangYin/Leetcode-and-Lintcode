import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node expTree(String s) {
        Map<Character, Integer> prio = new HashMap<>();
        prio.put('(', 1);
        prio.put('+', 2);
        prio.put('-', 2);
        prio.put('*', 3);
        prio.put('/', 3);
        
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Node> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ops.push(ch);
            } else if (Character.isDigit(ch)) {
                stack.push(new Node(ch));
            } else if (ch == ')') {
                while (ops.peek() != '(') {
                    combine(ops, stack);
                }
                ops.pop();
            } else {
                while (!ops.isEmpty() && prio.get(ops.peek()) > prio.get(ch)) {
                    combine(ops, stack);
                }
                
                ops.push(ch);
            }
        }
        
        while (stack.size() > 1) {
            combine(ops, stack);
        }
        
        return stack.peek();
    }
    
    private void combine(Deque<Character> ops, Deque<Node> stack) {
        Node root = new Node(ops.pop());
        root.right = stack.pop();
        root.left = stack.pop();
    
        stack.push(root);
    }
    
    public static void main(String[] args) {
        // Node node = new Solution().expTree("3*4-2*5");
        Node node = new Solution().expTree("2-3/(5*2)+1");
        System.out.println(node);
    }
}

class Node {
    char val;
    Node left, right;
    
    public Node(char val) {
        this.val = val;
    }
}