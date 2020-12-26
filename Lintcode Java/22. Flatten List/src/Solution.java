import java.security.interfaces.ECKey;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        for (NestedInteger ele : nestedList)
            if (ele.isInteger())
                result.add(ele.getInteger());
            else
                result.addAll(flatten(ele.getList()));
        return result;
    }
    
}

interface NestedInteger {
 
    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
