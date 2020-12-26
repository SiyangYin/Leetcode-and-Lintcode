import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack2 {
    
    class Pair {
        int val, count;
        
        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    
    private Deque<Integer> stack;
    private Deque<Pair> stackMin;
    
    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        stack = new ArrayDeque<>();
        stackMin = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (stackMin.isEmpty()) {
            stackMin.push(new Pair(x, 1));
        } else if (stackMin.peek().val == x) {
            stackMin.peek().count++;
        } else if (stackMin.peek().val > x) {
            stackMin.push(new Pair(x, 1));
        }
    }
    
    public void pop() {
        int x = stack.pop();
        if (stackMin.peek().val == x) {
            stackMin.peek().count--;
            if (stackMin.peek().count == 0) {
                stackMin.pop();
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return stackMin.peek().val;
    }
    
    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
