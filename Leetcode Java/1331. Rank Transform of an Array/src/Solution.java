import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        
        int[] res = Arrays.copyOf(arr, arr.length);
        Arrays.sort(res);
        
        int idx = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
            if (!map.containsKey(res[i])) {
                map.put(res[i], idx++);
            }
        }
        
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(arr[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution().arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12})));
    }
}
