import java.util.Arrays;

public class Solution {
    /**
     * @param m: the limit
     * @param k: the sum of choose
     * @param arr: the array
     * @return: yes or no
     */
    public String depress(int m, int k, int[] arr) {
        // Write your code here.
        if (arr == null) {
            return "no";
        }
        
        Arrays.sort(arr);
        int sadness = 0;
        for (int i = 0; i < k; i++) {
            sadness += arr[i];
        }
        
        if (sadness < m) {
            return "yes";
        } else {
            return "no";
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().depress(7, 3, new int[]{5, 3, 4, 2, 1}));
    }
}