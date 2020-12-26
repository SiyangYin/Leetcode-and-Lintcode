import java.util.Arrays;

public class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        int idx = 0, rem = nums.length - k;
        for (int i = 0; i < nums.length; i++) {
            while (idx > 0 && res[idx - 1] > nums[i] && rem > 0) {
                idx--;
                rem--;
            }
            
            if (idx < res.length ) {
                res[idx++] = nums[i];
            } else {
                rem--;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)));
    }
}
