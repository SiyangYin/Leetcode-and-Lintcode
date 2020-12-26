import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            set.add(n);
        }
    
        int res = 0;
        for (int n : arr) {
            res += set.contains(n + 1) ? 1 : 0;
        }
        
        return res;
    }
}
