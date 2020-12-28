import java.util.*;

public class Solution {
    
    private Random random;
    private Map<Integer, List<Integer>> map;
    
    public Solution(int[] nums) {
        random = new Random();
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
