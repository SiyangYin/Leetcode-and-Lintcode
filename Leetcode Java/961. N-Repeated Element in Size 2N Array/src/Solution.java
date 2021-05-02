import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int x : A) {
            if (set.contains(x)) {
                return x;
            }
            
            set.add(x);
        }
        
        return -1;
    }
}
