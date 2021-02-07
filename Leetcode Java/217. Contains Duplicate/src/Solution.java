import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}
