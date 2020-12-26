import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        obj.push(4);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

}
class MyQueue {
    Stack<Integer> enqueue;
    Stack<Integer> dequeue;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        enqueue = new Stack<>();
        dequeue = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        enqueue.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (dequeue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }
        }
        
        return dequeue.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (dequeue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }
        }
        
        return dequeue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return enqueue.isEmpty() && dequeue.isEmpty();
    }
}