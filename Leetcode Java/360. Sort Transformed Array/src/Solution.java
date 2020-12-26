import java.util.Arrays;

public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] res = new int[nums.length];
        int idx = 0;
        
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int f1 = f(nums[i], a, b, c), f2 = f(nums[j], a, b, c);
            if (a > 0) {
                if (f1 >= f2) {
                    res[idx++] = f1;
                    i++;
                } else {
                    res[idx++] = f2;
                    j--;
                }
            } else {
                if (f1 <= f2) {
                    res[idx++] = f1;
                    i++;
                } else {
                    res[idx++] = f2;
                    j--;
                }
            }
        }
        
        if (a > 0) {
            reverse(res);
        }
        
        return res;
    }
    
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
    
    private int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5)));
    }
}
