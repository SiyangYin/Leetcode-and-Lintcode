public class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            }
        }
    
        int res = count;

        int oneCount = 0, zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            
            res = Math.min(res, zeroCount + count - oneCount);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().flipDigit(new int[]{1, 0, 0, 1, 1, 1}));
        System.out.println(new Solution().flipDigit(new int[]{1, 0, 1, 0, 1, 0}));
        System.out.println(new Solution().flipDigit(new int[]{1, 0, 1, 0, 1, 0,0,0,0}));
        System.out.println(new Solution().flipDigit(
                new int[]{
                        0, 0, 0, 0, 1, 1, 1, 1, 1, 1,
                        0, 0, 0, 0, 1, 0, 0, 1, 1, 1,
                        0, 1, 1, 1, 1, 0, 1, 0, 1, 1,
                        1, 0, 1, 0, 1, 1, 0, 1, 0, 1,
                        1, 1, 1, 0, 0, 0, 1, 0, 0, 0}));
    }
}
