public class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        int idx = 1;
    
        for (int i = 0, j = 0, k = 0; idx < n + 1; ) {
            int next = Math.min(nums[i] * a, Math.min(nums[j] * b, nums[k] * c));
            nums[idx++] = next;
            if (next / a == nums[i]) {
                i++;
            }
            if (next / b == nums[j]) {
                j++;
            }
            if (next / c == nums[k]) {
                k++;
            }
        }
        
        return nums[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(5, 2, 11, 13));
    }
}
