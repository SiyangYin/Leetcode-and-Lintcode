import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SetOfStacks2 {
    
    private List<Deque<Integer>> stacks;
    private int capacity;
    
    /*
     * @param capacity: an inetger, capacity of sub stack
     */
    public SetOfStacks2(int capacity) {
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
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == capacity) {
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
    
    /*
     * @param index: The index of a specific sub-stack
     * @return: top element of the specific sub-stack
     */
    public int popAt(int index) {
        // write your code here
        int res = stacks.get(index).pop();
        
        for (int i = index + 1; i < stacks.size(); i++) {
            stacks.get(i - 1).push(stacks.get(i).pollLast());
        }
        
        if (stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        
        return res;
    }
}