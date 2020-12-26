import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: an array of integers
     * @param k:    an integer
     * @return: the number of unique k-diff pairs
     */
    public int findPairs(int[] nums, int k) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), count = entry.getValue();
            if (k == 0) {
                if (count > 1) {
                    res++;
                }
            } else {
                if (map.containsKey(key + k)) {
                    res++;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }
}
