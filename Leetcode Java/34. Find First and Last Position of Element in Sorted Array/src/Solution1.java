import java.util.Arrays;

public class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (nums[m] < target) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        if (nums[l] != target) return new int[]{-1, -1};
        while (l > 0 && nums[l - 1] == target) l--;
        while (r < nums.length - 1 && nums[r + 1] == target) r++;
        return new int[]{l, r};
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
