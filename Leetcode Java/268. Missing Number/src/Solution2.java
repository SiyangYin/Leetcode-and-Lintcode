public class Solution2 {
    public int missingNumber(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i] ^ i;
        }
        x ^= nums.length;
        return x;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{3, 0, 1}));
    }
}
