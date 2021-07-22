public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int BASE = (int) 2e3, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= BASE) {
                continue;
            }
            
            int p = i, mark = BASE + i;
            int lastStep = 0;
            boolean sign = nums[p] > 0;
            do {
                int next = ((p + nums[p]) % n + n ) % n;
                lastStep = nums[p];
                nums[p] = mark;
                p = next;
            } while (nums[p] < BASE && sign == nums[p] > 0);
            
            if (lastStep % n != 0 && nums[p] == mark) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
    }
}
