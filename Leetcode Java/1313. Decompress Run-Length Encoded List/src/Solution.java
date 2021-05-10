public class Solution {
    public int[] decompressRLElist(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i += 2) {
            cnt += nums[i];
        }
        
        int[] res = new int[cnt];
        for (int i = 0, idx = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                res[idx++] = nums[i + 1];
            }
        }
        
        return res;
    }
}
