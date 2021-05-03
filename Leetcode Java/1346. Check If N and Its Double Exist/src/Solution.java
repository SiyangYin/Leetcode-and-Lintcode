import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            if (set.contains(x * 2) || (x % 2 == 0 && set.contains(x / 2))) {
                return true;
            }
            
            set.add(x);
        }
        
        return false;
    }
}
