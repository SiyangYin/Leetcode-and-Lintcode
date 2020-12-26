import java.util.ArrayDeque;
import java.util.Deque;

public class MaxStack {
    
    Deque<Integer> stk, maxStk;
    
    public MaxStack() {
        stk = new ArrayDeque<>();
        maxStk = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stk.push(x);
        if (maxStk.isEmpty() || maxStk.peek() <= x) {
            maxStk.push(x);
        }
    }
    
    public int pop() {
        int x = stk.pop();
        if (!maxStk.isEmpty() && x == maxStk.peek()) {
            maxStk.pop();
        }
        
        return x;
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int peekMax() {
        return maxStk.peek();
    }
    
    public int popMax() {
        Deque<Integer> tempStk = new ArrayDeque<>();
        int x = maxStk.pop();
        while (!stk.isEmpty() && stk.peek() < x) {
            tempStk.push(stk.pop());
        }
        
        stk.pop();
        while (!tempStk.isEmpty()) {
            push(tempStk.pop());
        }
        
        return x;
    }
    
    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        System.out.println(stack.popMax());
        System.out.println(stack.peekMax());
    }
}
