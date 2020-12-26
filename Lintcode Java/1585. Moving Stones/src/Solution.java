import java.util.Arrays;

public class Solution {
    /**
     * @param arr: the positions
     * @return: minimum number of moves
     */
    public int movingStones(int[] arr) {
        // Write your code here
        Arrays.sort(arr);
        
        int odd = 0, even = 0;
        for (int i = 0; i < arr.length; i++) {
            odd += Math.abs(arr[i] - (2 * i + 1));
            even += Math.abs(arr[i] - (2 * i + 2));
        }
        
        return Math.min(odd, even);
    }
}
