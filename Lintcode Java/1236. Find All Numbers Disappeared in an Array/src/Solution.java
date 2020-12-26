import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return a list of integers
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // write your code here
        List<Integer> res = new ArrayList<>();
    
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
    
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        
        return res;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
