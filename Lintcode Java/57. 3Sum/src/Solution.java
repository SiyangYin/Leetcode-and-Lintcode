import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (List<Integer> list : twoSum(numbers, i, -numbers[i])) {
                list.add(0, numbers[i]);
                res.add(list);
            }
        }
        
        return res;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int i, int target) {
        int l = i + 1, r = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < target || (l > i + 1 && nums[l] == nums[l - 1])) {
                l++;
            } else if (sum > target || (r < nums.length - 1 && nums[r] == nums[r + 1])) {
                r--;
            } else {
                res.add(new ArrayList<>(Arrays.asList(nums[l], nums[r])));
                l++;
                r--;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{1, 0, 0,-1, -1, -1, -1, 0, 1, 1, 1}));
    }
}
