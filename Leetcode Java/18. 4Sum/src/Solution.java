import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
    
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
    
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    if (l > j + 1 && nums[l] == nums[l - 1]) {
                        l++;
                        continue;
                    }
                    if (r < nums.length - 1 && nums[r] == nums[r + 1]) {
                        r--;
                        continue;
                    }
                    
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    }
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
