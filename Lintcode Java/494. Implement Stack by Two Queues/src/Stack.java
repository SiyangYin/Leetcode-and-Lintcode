import java.util.ArrayDeque;
import java.util.Queue;

public class Stack {
    
    Queue<Integer> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
    
    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        q1.offer(x);
    }
    
    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        
        q1.poll();
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }
    
    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
    
        int res = q1.peek();
        q2.offer(q1.poll());
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        
        return res;
    }
    
    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return q1.isEmpty();
    }
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.pop();
        stack.push(2);
        System.out.println(stack.isEmpty());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.isEmpty());
    }
}