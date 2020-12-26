import java.util.List;

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        return dfs(nestedList, 1);
    }
    
    private int dfs(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.isEmpty()) {
            return 0;
        }
    
        int sum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger() * depth;
            } else {
                sum += dfs(nestedInteger.getList(), depth + 1);
            }
        }
        
        return sum;
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