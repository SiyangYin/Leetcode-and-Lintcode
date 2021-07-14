public class Solution {
    /**
     * @param nums: a sorted array
     * @param a:
     * @param b:
     * @param c:
     * @return: a sorted array
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        // Write your code here
        int[] res = new int[nums.length];
        for (int i = 0, j = nums.length - 1, idx = 0; i <= j; ) {
            int l = compute(a, b, c, nums[i]), r = compute(a, b, c, nums[j]);
            if ((a > 0 && l >= r) || (a < 0 && l <= r)) {
                res[idx++] = l;
                i++;
            } else {
                res[idx++] = r;
                j--;
            }
        }
        
        if (res.length > 1 && res[0] > res[1]) {
            reverse(res);
        }
        
        return res;
    }
    
    private void reverse(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
    
    private int compute(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}
