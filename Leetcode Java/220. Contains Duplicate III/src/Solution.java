import java.util.TreeMap;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) {
            return false;
        }
        
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(Long.MIN_VALUE, 1);
        map.put(Long.MAX_VALUE, 1);
        for (int i = 0; i < nums.length; i++) {
            long cur = nums[i];
            if (cur + t >= map.ceilingKey(cur) || cur - t <= map.floorKey(cur)) {
                return true;
            }
            
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            if (i >= k) {
                long prev = nums[i - k];
                map.put(prev, map.get(prev) - 1);
                if (map.get(prev) == 0) {
                    map.remove(prev);
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}, 1, 1));
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, 1, 1));
    }
}
