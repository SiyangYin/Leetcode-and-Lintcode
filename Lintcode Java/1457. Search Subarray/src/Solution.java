import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param arr: The array
     * @param k:   the sum
     * @return: The length of the array
     */
    public int searchSubarray(int[] arr, int k) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            map.put(arr[i], i);
        }
        map.put(0, -1);
        
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - k) && i > map.get(arr[i] - k)) {
                return i - map.get(arr[i] - k);
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().searchSubarray(new int[]{1, -1, 0}, 0));
        System.out.println(new Solution().searchSubarray(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(new Solution().searchSubarray(new int[]{3, 5, 7, 10, 2}, 12));
    }
}
