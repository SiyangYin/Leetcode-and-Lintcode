public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == n) {
                count++;
            } else {
                if (count == 0) {
                    n = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        
        return n;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{3, 2, 3}));
    }
}
