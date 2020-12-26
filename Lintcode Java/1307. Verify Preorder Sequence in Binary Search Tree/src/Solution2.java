import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    /**
     * @param preorder: List[int]
     * @return: return a boolean
     */
    public boolean verifyPreorder(int[] preorder) {
        // write your code here
        int min = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < preorder.length; i++) {
            if (stack.isEmpty()) {
                stack.push(preorder[i]);
                continue;
            }
            
            if (preorder[i] <= min) {
                return false;
            }
            
            if (stack.peek() > preorder[i]) {
                stack.push(preorder[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < preorder[i]) {
                    min = stack.pop();
                }
                
                stack.push(preorder[i]);
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().verifyPreorder(new int[]{1, 3, 2}));
        System.out.println(new Solution2().verifyPreorder(new int[]{1, 2}));
    }
}
