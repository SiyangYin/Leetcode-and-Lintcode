import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[idx]) {
                stack.pop();
                idx++;
            }
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5},
                new int[]{4, 5, 3, 2, 1}));
    }
}
