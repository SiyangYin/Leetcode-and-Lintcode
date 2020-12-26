import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * @param nestedList: a list of NestedInteger
     * @return: the sum
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // Write your code here.
        if (nestedList == null || nestedList.isEmpty()) {
            return 0;
        }
        
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger nestedInteger : nestedList) {
            queue.offer(nestedInteger);
        }
        
        int res = 0, prefSum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger integer = queue.poll();
                if (integer.isInteger()) {
                    prefSum += integer.getInteger();
                } else {
                    for (NestedInteger nestedInteger : integer.getList()) {
                        queue.offer(nestedInteger);
                    }
                }
            }
            res += prefSum;
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