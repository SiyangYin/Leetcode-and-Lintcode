import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: List[int]
     * @return: return List[str]
     */
    public String[] findRelativeRanks(int[] nums) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
    
        Arrays.sort(nums);
        reverse(nums);
        String[] res = new String[nums.length];
    
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[map.get(nums[i])] = "Gold Medal";
            } else if (i == 1) {
                res[map.get(nums[i])] = "Silver Medal";
            } else if (i == 2) {
                res[map.get(nums[i])] = "Bronze Medal";
            } else {
                res[map.get(nums[i])] = String.valueOf(i + 1);
            }
        }
        
        return res;
    }
    
    private void reverse(int[] nums) {
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }
}
