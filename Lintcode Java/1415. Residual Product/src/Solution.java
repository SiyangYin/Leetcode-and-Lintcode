import java.util.Arrays;

public class Solution {
    /**
     * @param arr: The array you should handle
     * @return: Return the product
     */
    public int[] getProduct(int[] arr) {
        // Write your code here
        int[] res = new int[arr.length];
        if (arr.length == 1) {
            return res;
        }
        
        long prod = 1;
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                prod *= arr[i];
            } else {
                zeroCount++;
            }
        }
        
        if (zeroCount == 1) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    res[i] = (int) prod;
                } else {
                    res[i] = 0;
                }
            }
        } else if (zeroCount == 0) {
            for (int i = 0; i < arr.length; i++) {
                res[i] = (int) (prod / arr[i]);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getProduct(new int[]{9, 9, 9, 9, 9, 9, 6, 8, 10, -9})));
    }
}
