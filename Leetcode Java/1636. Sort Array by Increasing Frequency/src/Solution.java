import java.util.*;

public class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                list.add(num);
            }
            
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        list.sort((x, y) -> {
            int fx = map.get(x), fy = map.get(y);
            if (fx != fy) {
                return Integer.compare(fx, fy);
            } else {
                return -Integer.compare(x, y);
            }
        });
    
        for (int i = 0, idx = 0; i < list.size(); i++) {
            int num = list.get(i);
            for (int k = 0; k < map.get(num); k++, idx++) {
                nums[idx] = num;
            }
        }
        
        return nums;
    }
}
