import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    
    private Deque<NestedInteger> stk;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stk = new ArrayDeque<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stk.push(nestedList.get(i));
        }
    }
    
    @Override
    public Integer next() {
        if (hasNext()) {
            return stk.pop().getInteger();
        } else {
            return null;
        }
    }
    
    @Override
    public boolean hasNext() {
        while (!stk.isEmpty() && !stk.peek().isInteger()) {
            NestedInteger topList = stk.pop();
            for (int i = topList.getList().size() - 1; i >= 0; i--) {
                stk.push(topList.getList().get(i));
            }
        }
        
        return !stk.isEmpty();
    }
}

interface NestedInteger {
    boolean isInteger();
    
    Integer getInteger();
    
    List<NestedInteger> getList();
}