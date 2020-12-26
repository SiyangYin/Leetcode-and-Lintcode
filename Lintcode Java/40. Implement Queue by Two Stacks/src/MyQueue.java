import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    
    public MyQueue() {
        // do intialization if necessary
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }
    
    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        inStack.push(element);
    }
    
    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        
        return outStack.pop();
    }
    
    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (!outStack.isEmpty()) {
            return outStack.peek();
        }
    
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    
        return outStack.peek();
    }
}