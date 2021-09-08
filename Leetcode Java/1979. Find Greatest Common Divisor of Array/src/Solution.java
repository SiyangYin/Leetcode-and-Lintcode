public class Solution {
    public int findGCD(int[] nums) {
        int x = nums[0], y = nums[0];
        for (int num : nums) {
            x = Math.min(x, num);
            y = Math.max(y, num);
        }
        
        return gcd(x, y);
    }
    
    int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
