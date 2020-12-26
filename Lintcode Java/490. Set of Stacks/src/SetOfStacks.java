import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SetOfStacks {
    
    List<Deque<Integer>> stacks;
    int capacity;
    
    /*
     * @param capacity: An inetger, capacity of sub stack
     */
    public SetOfStacks(int capacity) {
        // do intialization if necessary
        stacks = new ArrayList<>();
        this.capacity = capacity;
    }
    
    /*
     * @param v: An integer
     * @return: nothing
     */
    public void push(int v) {
        // write your code here
        if (stacks.isEmpty()) {
            stacks.add(new ArrayDeque<>());
        }
        if (stacks.get(stacks.size() - 1).size() == capacity) {
            stacks.add(new ArrayDeque<>());
        }
        stacks.get(stacks.size() - 1).push(v);
    }
    
    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int res = stacks.get(stacks.size() - 1).pop();
        if (stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks(2);
        stacks.push(1);
        stacks.push(2);
        stacks.push(4);
        stacks.push(8);
        stacks.push(16);
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
    }
}