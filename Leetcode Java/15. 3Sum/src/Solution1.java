import java.util.*;

class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            Integer old = null;
            for(int j = i + 1; j < nums.length; j++) {
                if(set.contains(0 - nums[i] - nums[j]) && (null == old || 0 - nums[i] - nums[j] != old)) {
                    res.add(Arrays.asList(nums[i], 0 - nums[i] - nums[j], nums[j]));
                    old = 0 - nums[i] - nums[j];
                    set.remove(0 - nums[i] - nums[j]);
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
