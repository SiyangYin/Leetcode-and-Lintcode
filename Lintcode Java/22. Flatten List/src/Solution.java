import java.util.ArrayList;
import java.util.List;

public class Solution {
    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        for (NestedInteger e : nestedList) {
            if (e.isInteger()) {
                res.add(e.getInteger());
            } else {
                res.addAll(flatten(e.getList()));
            }
        }
        
        return res;
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
