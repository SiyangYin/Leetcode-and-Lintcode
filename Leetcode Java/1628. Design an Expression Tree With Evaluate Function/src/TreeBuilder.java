import java.util.Deque;
import java.util.LinkedList;

public class TreeBuilder {
    Node buildTree(String[] postfix) {
        Deque<Node> stack = new LinkedList<>();
        
        for (int i = 0; i < postfix.length; i++) {
            String s = postfix[i];
            if (Character.isDigit(s.charAt(0))) {
                stack.push(new TreeNode(s));
            } else {
                Node right = stack.pop(), left = stack.pop();
                TreeNode root = new TreeNode(s);
                root.left = left;
                root.right = right;
                stack.push(root);
            }
        }
        
        return stack.peek();
    }
}

class TreeNode extends Node {
    
    public TreeNode(String val) {
        this.val = val;
    }
    
    @Override
    public int evaluate() {
        if (Character.isDigit(val.charAt(0))) {
            return Integer.parseInt(val);
        }
        
        int left = this.left.evaluate(), right = this.right.evaluate();
        switch (val) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/": return left / right;
        }
        
        return 0;
    }
}

abstract class Node {
    public abstract int evaluate();
    
    // define your fields here
    String val;
    Node left, right;
}