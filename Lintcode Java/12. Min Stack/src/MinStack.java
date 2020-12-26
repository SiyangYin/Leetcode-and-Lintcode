import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    
    public MinStack() {
        // do intialization if necessary
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty() || minStack.peek() >= number) {
            minStack.push(number);
        }
    }
    
    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }
    
    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.peek();
    }
}