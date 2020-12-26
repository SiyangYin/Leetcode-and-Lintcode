import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        if (nums == null) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        
        int idx = -1;
        for (int num : set) {
            nums[++idx] = num;
        }
        
        return idx + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().deduplication(new int[]{1, 3, 1, 4, 4, 2}));
    }
}