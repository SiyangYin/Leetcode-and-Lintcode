import java.util.Arrays;

public class Solution {
    
    private int[] res;
    private int len;
    
    public int[] createTargetArray(int[] nums, int[] index) {
        res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            insert(index[i], nums[i]);
        }
        
        return res;
    }
    
    private void insert(int idx, int x) {
        if (idx == len) {
            res[len++] = x;
            return;
        }
    
        for (int i = len - 1; i >= idx; i--) {
            res[i + 1] = res[i];
        }
        res[idx] = x;
        len++;
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        System.out.println(Arrays.toString(new Solution().createTargetArray(nums, index)));
    }
}
