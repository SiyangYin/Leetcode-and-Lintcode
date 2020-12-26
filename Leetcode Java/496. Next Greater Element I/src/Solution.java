import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if (nums2 == null || nums2.length == 0) {
            Arrays.fill(res, -1);
            return res;
        }
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            stack.push(nums2[i]);
        }
    
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(nums1, nums2)));
    }
}
