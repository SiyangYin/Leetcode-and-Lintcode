import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int res = 0;
        
        Queue<NestedInteger> queue = new LinkedList<>();
        int sum = 0;
        for (NestedInteger num : nestedList) {
            queue.offer(num);
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    sum += cur.getInteger();
                } else {
                    for (NestedInteger next : cur.getList()) {
                        queue.offer(next);
                    }
                }
            }
            
            res += sum;
        }
        
        return res;
    }
}

interface NestedInteger {
    // Constructor initializes an empty nested list.
    // NestedInteger();
    
    // Constructor initializes a single integer.
    // NestedInteger(int value);
    
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();
    
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();
    
    // Set this NestedInteger to hold a single integer.
    void setInteger(int value);
    
    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    void add(NestedInteger ni);
    
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}