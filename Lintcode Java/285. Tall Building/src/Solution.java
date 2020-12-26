import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    /**
     * @param arr: the height of all buildings
     * @return: how many buildings can he see at the location of each building
     */
    public int[] tallBuilding(int[] arr) {
        // Write your code here.
        int[] res = new int[arr.length];
        Arrays.fill(res, 1);
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            res[i] += stack.size();
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            stack.push(arr[i]);
        }
        
        stack.clear();
    
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] += stack.size();
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
    
            stack.push(arr[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().tallBuilding(new int[]{5, 3, 8, 3, 2, 5})));
    }
}
