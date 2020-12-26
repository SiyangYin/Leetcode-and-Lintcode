import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param array: the input array
     * @param k: the sequence length
     * @return: if it is possible, return true, otherwise false
     */
    public boolean partitionArratIII(int[] array, int k) {
        // write your code here
        if (array == null || array.length == 0) {
            return k == 0;
        }
        
        if (k == 0) {
            return false;
        }
        
        if (array.length % k != 0) {
            return false;
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : array) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) > array.length / k) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().partitionArratIII(new int[]{1, 2, 3, 4}, 2));
    }
}
