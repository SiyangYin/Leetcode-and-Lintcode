import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(Collections.min(set));
            }
        }
        
        return set.size() == 3 ? Collections.min(set) : Collections.max(set);
    }
}
