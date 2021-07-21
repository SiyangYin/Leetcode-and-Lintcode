public class Solution {
    public int[] buildArray(int[] nums) {
        int mask = (1 << 10) - 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] |= (nums[nums[i]] & mask) << 10;
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] >> 10;
        }
        
        return nums;
    }
    
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE).length());
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE).length());
        System.out.println(Integer.toBinaryString(-1).length());
    }
}
