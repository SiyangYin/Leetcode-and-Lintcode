import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param arr: an integer array
     * @return: return the median array when delete a number
     */
    public int[] getMedian(int[] arr) {
        // write your code here
        int[] res = Arrays.copyOf(arr, arr.length);
        Arrays.sort(res);
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
            if (i < res.length / 2) {
                map.put(res[i], res[res.length / 2]);
            } else {
                map.put(res[i], res[res.length / 2 - 1]);
            }
        }
    
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(arr[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getMedian(new int[]{1, 2, 3, 4, 5, 6})));
    }
}
