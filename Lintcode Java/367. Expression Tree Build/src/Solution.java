import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        Deque<ExpressionTreeNode> stack = new ArrayDeque<>();
        Deque<String> ops = new ArrayDeque<>();
        
        Map<String, Integer> prec = new HashMap<>();
        prec.put("(", 1);
        prec.put("+", 2);
        prec.put("-", 2);
        prec.put("*", 3);
        prec.put("/", 3);
        
        for (String s : expression) {
            if (!prec.containsKey(s) && !")".equals(s)) {
                stack.push(new ExpressionTreeNode(s));
            } else if ("(".equals(s)) {
                ops.push(s);
            } else if (")".equals(s)) {
                while (!"(".equals(ops.peek())) {
                    pushTree(ops, stack);
                }
                ops.pop();
            } else {
                while (!ops.isEmpty() && prec.get(ops.peek()) >= prec.get(s)) {
                    pushTree(ops, stack);
                }
                ops.push(s);
            }
        }
        
        while (stack.size() > 1) {
            pushTree(ops, stack);
        }
        
        return stack.peek();
    }
    
    private void pushTree(Deque<String> ops, Deque<ExpressionTreeNode> stack) {
        ExpressionTreeNode op = new ExpressionTreeNode(ops.pop()), n2 = stack.pop(), n1 = stack.pop();
        op.left = n1;
        op.right = n2;
        stack.push(op);
    }
    
    public static void main(String[] args) {
        String[] exp = "2 * 6 - ( 23 + 7 ) / ( 1 + 2 )".split(" ");
        System.out.println(new Solution().build(exp));
        new Solution().dfs(new Solution().build(exp));
    }
    
    private void dfs(ExpressionTreeNode r) {
        if (r == null) {
            return;
        }
        
        System.out.println(r.symbol);
        dfs(r.left);
        dfs(r.right);
    }
}

class ExpressionTreeNode {
    String symbol;
    ExpressionTreeNode left, right;
    
    ExpressionTreeNode(String symbol) {
        this.symbol = symbol;
    }
}