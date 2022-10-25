import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack3 {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    public MinStack3() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty() || val <= stack2.peek()) {
            stack2.push(val);
        }
    }

    public void pop() {
        if (stack1.peek().equals(stack2.peek())) {
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
    
    public static void main(String[] args) {
        MinStack3 minStack = new MinStack3();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
