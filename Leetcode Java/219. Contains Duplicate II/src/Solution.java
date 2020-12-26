import java.util.HashMap;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int j;
        for (int i = 0; i < nums.length; i++) {
            j = map.getOrDefault(nums[i], -1);
            map.put(nums[i], i);
            if (j != -1 && i - j <= k) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}