import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        Deque<NestedInteger> stack = new LinkedList<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
        
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            NestedInteger top = stack.pop();
            if (top.isInteger()) {
                res.add(top.getInteger());
            } else {
                List<NestedInteger> list = top.getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }
        }
        
        return res;
    }
}
