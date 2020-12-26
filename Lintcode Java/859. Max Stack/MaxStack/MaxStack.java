import java.util.ArrayDeque;
import java.util.Deque;

class MaxStack {
    
    private Deque<Integer> stack, maxStack;
    
    public MaxStack() {
        // do intialization if necessary
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }
    
    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        stack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }
    
    public int pop() {
        // write your code here
        int x = stack.pop();
        if (x == maxStack.peek()) {
            maxStack.pop();
        }
        
        return x;
    }
    
    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        return stack.peek();
    }
    
    /*
     * @return: An integer
     */
    public int peekMax() {
        // write your code here
        return maxStack.peek();
    }
    
    /*
     * @return: An integer
     */
    public int popMax() {
        // write your code here
        int x = maxStack.pop();
        while (!stack.isEmpty() && stack.peek() != x) {
            stack.pop();
        }
        
        stack.pop();
        return x;
    }
    
    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
    
        System.out.println(stack.top());
    }
}