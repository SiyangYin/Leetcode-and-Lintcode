import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>(), cnt1 = new HashMap<>();
        for (int x : nums) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        
        for (int x : nums) {
            if (cnt.get(x) == 0) {
                continue;
            }
            
            if (cnt1.getOrDefault(x - 1, 0) != 0) {
                cnt1.put(x - 1, cnt1.get(x - 1) - 1);
                cnt1.put(x, cnt1.getOrDefault(x, 0) + 1);
                cnt.put(x, cnt.get(x) - 1);
            } else if (cnt.getOrDefault(x + 1, 0) != 0 && cnt.getOrDefault(x + 2, 0) != 0) {
                cnt1.put(x + 2, cnt1.getOrDefault(x + 2, 0) + 1);
                cnt.put(x, cnt.get(x) - 1);
                cnt.put(x + 1, cnt.get(x + 1) - 1);
                cnt.put(x + 2, cnt.get(x + 2) - 1);
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isPossible(new int[]{1, 2, 3, 3, 4, 5}));
    }
}
