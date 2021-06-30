public class Solution {
    /**
     * @param nums: the gievn integers
     * @return: the total Hamming distance between all pairs of the given numbers
     */
    public int totalHammingDistance(int[] nums) {
        // Write your code here
        int[] cnt = new int[32];
        for (int x : nums) {
            int pos = 0;
            while (x != 0) {
                cnt[pos++] += x & 1;
                x >>= 1;
            }
        }
        
        int res = 0;
        for (int x : cnt) {
            res += x * (nums.length - x);
        }
        
        return res;
    }
}
