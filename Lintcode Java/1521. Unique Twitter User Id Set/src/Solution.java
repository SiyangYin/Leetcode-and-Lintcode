import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param arr: a integer array
     * @return: return ids sum is minimum.
     */
    public int UniqueIDSum(int[] arr) {
        // write your code here
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] >= arr[i + 1]) {
                arr[i + 1] = arr[i] + 1;
            }
        }
        
        int res = 0;
        for (int i : arr) {
            res += i;
        }
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().UniqueIDSum(new int[]{3, 2, 1, 2, 7}));
        System.out.println(new Solution().UniqueIDSum(new int[]{1, 1, 1, 1, 2, 2, 1}));
    }
}
