import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param arr: a integer array
     * @return: return the unique array
     */
    public int[] getUniqueArray(int[] arr) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            map.put(arr[i], i);
        }
        
        int[] res = new int[map.size()];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == map.get(arr[i])) {
                res[idx++] = arr[i];
            }
        }
        
        return res;
    }
}
