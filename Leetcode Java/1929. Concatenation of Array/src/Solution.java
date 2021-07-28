public class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length << 1];
        for (int i = 0; i < nums.length << 1; i++) {
            res[i] = nums[i % nums.length];
        }
        
        return res;
    }
}
