import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        reverse(citations);
        // 6 5 3 1 0
        int l = 0, r = citations.length;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (citations[m - 1] >= m) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return l;
    }
    
    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
