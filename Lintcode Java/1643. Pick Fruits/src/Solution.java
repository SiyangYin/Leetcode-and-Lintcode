import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param arr: the arr
     * @return: the length of the longset subarray
     */
    public int pickFruits(int[] arr) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
    
        int res = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while (map.size() > 2) {
                map.put(arr[j], map.get(arr[j]) - 1);
                if (map.get(arr[j]) == 0) {
                    map.remove(arr[j]);
                }
                
                j++;
            }
            
            res = Math.max(res, i - j + 1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().pickFruits(new int[]{1, 2, 1, 3, 4, 3, 5, 1, 2}));
    }
}
