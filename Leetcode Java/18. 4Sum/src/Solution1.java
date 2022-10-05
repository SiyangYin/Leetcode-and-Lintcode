import java.util.*;

public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int subTarget1 = target - nums[i];
            if (target < 0 && nums[i] > 0 && subTarget1 > 0 || target > 0 && nums[i] < 0 && subTarget1 < 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int subTarget2 = subTarget1 - nums[j];
                if (subTarget1 < 0 && nums[j] > 0 && subTarget2 > 0 || subTarget1 > 0 && nums[j] < 0 && subTarget2 < 0) {
                    continue;
                }
                Set<Integer> set = new HashSet<>();
                Integer old = null;
                for (int k = j + 1; k < nums.length; k++) {
                    if (set.contains(subTarget2 - nums[k])) {
                        if (null == old || subTarget2 - nums[k] != old) {
                            res.add(Arrays.asList(nums[i], nums[j], subTarget2 - nums[k], nums[k]));
                            old = subTarget2 - nums[k];
                        }
                    }
                    else {
                        set.add(nums[k]);
                    }
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution1().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(new Solution1().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296));
    }
}
