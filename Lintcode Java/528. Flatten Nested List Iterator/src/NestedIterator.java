import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    
    private Deque<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        stack = new LinkedList<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
    
    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        return stack.pop().getInteger();
    }
    
    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek();
            if (top.isInteger()) {
                return true;
            }
            
            stack.pop();
            for (int i = top.getList().size() - 1; i >= 0; i--) {
                stack.push(top.getList().get(i));
            }
        }
        
        return false;
    }
    
    @Override
    public void remove() {
        next();
    }
}

interface NestedInteger {
    
    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    boolean isInteger();
    
    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();
    
    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}