import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return res;
        }
        Arrays.sort(nums);
    
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            List<int[]> two = twoSum(nums, i + 1, nums.length - 1, -nums[i]);
            for (int[] pair : two) {
                List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], pair[0], pair[1]));
                res.add(triplet);
            }
        }
        
        return res;
    }
    
    private List<int[]> twoSum(int[] nums, int l, int r, int target) {
        List<int[]> res = new ArrayList<>();
        int i = l, j = r;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                res.add(new int[]{nums[i], nums[j]});
                i++;
                j--;
            }
    
            while (i < j && i > l && nums[i] == nums[i - 1]) {
                i++;
            }
            while (i < j && j < r && nums[j] == nums[j + 1]) {
                j--;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-2, 0, 0, 2, 2}));
    }
}
