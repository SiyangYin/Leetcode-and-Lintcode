import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * @param prices: a list of integer
     * @return: return the actual prices
     */
    public int[] FinalDiscountedPrice(int[] prices) {
        // write your code here
        Deque<Integer> stack = new LinkedList<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.peek()] -= prices[i];
                stack.pop();
            }
            
            stack.push(i);
        }
        
        return prices;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().FinalDiscountedPrice(new int[]{2, 3, 1, 2, 4, 2})));
    }
}
