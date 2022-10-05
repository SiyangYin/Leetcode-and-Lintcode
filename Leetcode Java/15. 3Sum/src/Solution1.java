import java.util.*;

class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int subTarget = 0 - nums[i];
            Set<Integer> set = new HashSet<>();
            Integer old = null;
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(subTarget - nums[j])) {
                    if (null == old || subTarget - nums[j] != old) {
                        res.add(Arrays.asList(nums[i], subTarget - nums[j], nums[j]));
                        old = subTarget - nums[j];
                    }
                }
                else {
                    set.add(nums[j]);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution1().threeSum(new int[]{-2, 0, 0, 2, 2}));
    }
}
