import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Map<Integer, Boolean> map = new HashMap<>();
    
        int ind = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number) {
                ind = i;
                break;
            }
            map.put(nums[i], map.containsKey(nums[i]));
        }
        
        if (ind == -1) {
            return -1;
        }
    
        for (int i = 0; i < ind; i++) {
            if (!map.get(nums[i])) {
                return nums[i];
            }
        }
        
        return number;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqueNumber(new int[]{1, 2, 2, 1, 3, 4, 4, 5, 6}, 5));
    }
}
