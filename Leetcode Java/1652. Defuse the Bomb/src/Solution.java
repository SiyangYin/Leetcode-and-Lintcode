import java.util.Arrays;

public class Solution {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            return new int[code.length];
        }
        
        boolean reversed = false;
        if (k < 0) {
            k = -k;
            reverse(code);
            reversed = true;
        }
        
        int[] res = new int[code.length];
        int sum = 0;
        for (int i = 1; i < 1 + k; i++) {
            sum += code[i];
        }
        
        res[0] = sum;
        for (int i = 1; i < code.length; i++) {
            sum -= code[i];
            sum += code[(i + k) % code.length];
            res[i] = sum;
        }
     
        if (reversed) {
            reverse(res);
        }
        
        return res;
    }
    
    private void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(new Solution().decrypt(new int[]{5, 7, 1, 4}, 3)));
        System.out.println(Arrays.toString(new Solution().decrypt(new int[]{2, 4, 9, 3}, -2)));
    }
}
