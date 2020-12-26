import java.util.Arrays;

public class Solution {
    /**
     * @param stops: An array represents where each car stops.
     * @param k:     The number of cars should be covered.
     * @return: return the minimum length of the shed that meets the requirements.
     */
    public int calculate(int[] stops, int k) {
        // write your code here
        Arrays.sort(stops);
    
        int n = stops.length;
        if (n == k) {
            return stops[n - 1] - stops[0] + 1;
        }
        
        k++;
        int res = 0;
        for (int i = 0; i + k - 1 < n; i++) {
            res = Math.max(res, stops[i + k - 1] - stops[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().calculate(new int[]{7, 3, 6, 1, 8}, 3));
        System.out.println(new Solution().calculate(new int[]{7, 3, 6, 1, 8}, 2));
    }
}
