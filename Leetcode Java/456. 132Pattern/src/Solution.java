import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
    
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
    
        list.sort((x, y) -> -Integer.compare(x, y));
        
        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            stack.push(list.get(i));
            while (!stack.isEmpty() && stack.peek() == nums[idx]) {
                stack.pop();
                idx++;
            }
        }
        
        if (stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().find132pattern(new int[]{3, 1, 4, 2}));
    }
}