import java.util.Arrays;

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        
        int len = nums.length;
        int[] tmp = new int[len];
        int i = len - 1 >> 1, j = len - 1;
        
        int idx = 0;
        while (i >= 0 || j > len - 1 >> 1) {
            tmp[idx++] = nums[i--];
            if (idx < len) {
                tmp[idx++] = nums[j--];
            }
        }
        
        for (int k = 0; k < len; k++) {
            nums[k] = tmp[k];
        }
        
        System.out.println(Arrays.toString(nums));
    }
    
    public static void main(String[] args) {
        // new Solution().wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
        // new Solution().wiggleSort(new int[]{4, 5, 5, 6});
        new Solution().wiggleSort(new int[]{1});
    }
}
