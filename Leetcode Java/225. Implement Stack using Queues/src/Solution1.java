import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public static void main(String[] args) {
        MyStack1 stack = new MyStack1();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}

class MyStack1 {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    public MyStack1() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        Queue temp = q1;
        q1 = q2;
        q2 = temp;
        return q2.poll();
    }

    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}