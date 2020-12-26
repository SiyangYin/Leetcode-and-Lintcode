import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums1: an array
     * @param nums2: an array
     * @return: find all the next greater numbers for nums1's elements in the corresponding places of nums2
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            
            stack.push(nums2[i]);
        }
        
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return res;
    }
}