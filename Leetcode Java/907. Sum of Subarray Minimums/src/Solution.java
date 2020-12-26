import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        long res = 0;
        int MOD = (int) (1E9 + 7);
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int pos = stack.pop();
                long l = pos - (stack.isEmpty() ? -1 : stack.peek()), r = i - pos;
                res += (l * r % MOD) * arr[pos] % MOD;
                res %= MOD;
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int pos = stack.pop();
            long l = pos - (stack.isEmpty() ? -1 : stack.peek()), r = arr.length - pos;
            res += (l * r % MOD) * arr[pos] % MOD;
            res %= MOD;
        }
        
        return (int) res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }
}
