public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int idx1 = 0, idx2 = n;
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i += 2) {
            res[i] = nums[idx1++];
            res[i + 1] = nums[idx2++];
        }
        
        return res;
    }
}
