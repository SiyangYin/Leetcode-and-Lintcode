import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution2 {
    
    public static void main(String[] args) {
        System.out.println(new Solution2().canPartition(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }
    
    public boolean canPartition(int[] nums) {
        nums = IntStream.of(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        int half = sum / 2;
        if (half * 2 != sum) {
            return false;
        }
        
        return dfs(nums, 0, 0, half);
    }
    
    private boolean dfs(int[] nums, int pos, int sum, int target) {
        boolean found = false;
        for (int i = pos; i < nums.length; i++) {
            if (sum + nums[i] < target) {
                found |= dfs(nums, i + 1, sum + nums[i], target);
            } else if (sum + nums[i] == target) {
                return true;
            } else {
                break;
            }
            if (found) {
                return true;
            }
        }
        
        return found;
    }
}
