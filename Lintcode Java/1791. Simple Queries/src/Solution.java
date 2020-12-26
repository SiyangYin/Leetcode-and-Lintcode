public class Solution {
    /**
     * @param nums:
     * @param sub:
     * @return: return a Integer array
     */
    public int[] SimpleQueries (int[] nums, int[] sub) {
        // write your code here
        int[] res = new int[sub.length];
        
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        
        int[] preSum = new int[count.length + 1];
        for (int i = 0; i < count.length; i++) {
            preSum[i + 1] = preSum[i] + count[i];
        }
    
        for (int i = 0; i < sub.length; i++) {
            if (sub[i] >= max) {
                res[i] = nums.length;
            } else {
                res[i] = preSum[sub[i] + 1];
            }
        }
        
        return res;
    }
}
