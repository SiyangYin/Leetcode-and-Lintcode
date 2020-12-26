import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    
    private Deque<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
    
    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        } else {
            return null;
        }
    }
    
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger topList = stack.pop();
            for (int i = topList.getList().size() - 1; i >= 0; i--) {
                stack.push(topList.getList().get(i));
            }
        }
        
        return !stack.isEmpty();
    }
}

interface NestedInteger {
    boolean isInteger();
    
    Integer getInteger();
    
    List<NestedInteger> getList();
}