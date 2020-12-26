public class Solution {
    /**
     * @param nums: an array of positive and negative integers
     * @return: if there is a loop in this array
     */
    public boolean circularArrayLoop(int[] nums) {
        // Write your code here
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            
            int next = getNext(i, nums);
            if (next == i) {
                nums[i] = 0;
                continue;
            }
            
            int sign = nums[i];
            nums[i] = 0;
            while (nums[next] != 0) {
                if (sign * nums[next] < 0) {
                    nums[next] = 0;
                    break;
                }
                
                int tmp = next;
                next = getNext(next, nums);
                nums[tmp] = 0;
            }
            
            if (next == i) {
                return true;
            }
        }
        
        return false;
    }
    
    private int getNext(int cur, int[] nums) {
        return (cur + nums[cur] + nums.length) % nums.length;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
        System.out.println(new Solution().circularArrayLoop(new int[]{-1, 2}));
    }
}
