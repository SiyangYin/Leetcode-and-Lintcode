public class Solution1 {
    public int removeDuplicates(int[] nums) {
        int i = 1, j = 1, cnt = 1;
        while (j < nums.length) {
            if (nums[j - 1] != nums[j]) {
                cnt = 1;
            }
            else {
                cnt++;
            }
            if (cnt <= 2) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
