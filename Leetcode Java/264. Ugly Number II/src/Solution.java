public class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int idx = 1;
        nums[0] = 1;
        
        for (int two = 0, three = 0, five = 0; idx < n; ) {
            int next = Math.min(nums[two] * 2, Math.min(nums[three] * 3, nums[five] * 5));
            nums[idx++] = next;
            if (next / 2 == nums[two]) {
                two++;
            }
            if (next / 3 == nums[three]) {
                three++;
            }
            if (next / 5 == nums[five]) {
                five++;
            }
        }
        
        return nums[n - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(14));
        // System.out.println(new Solution().nthUglyNumber(1407));
    }
}
