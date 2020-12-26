import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * @param nums: the array of integers
     * @param target:
     * @return: the starting and ending position
     */
    public List<Integer> searchRange(List<Integer> nums, int target) {
        // Write your code here.
        if (nums == null || nums.isEmpty()) {
            return Arrays.asList(-1, -1);
        }
        
        int firstPos = 0, lastPos = 0;
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) > target) {
                right = mid - 1;
            } else if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums.get(left) != target) {
            return Arrays.asList(-1, -1);
        }
        firstPos = left;
        
        left = 0;
        right = nums.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (nums.get(mid) > target) {
                right = mid - 1;
            } else if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                left = mid;
            }
        }
        lastPos = left;
        
        return Arrays.asList(firstPos, lastPos);
    }
    
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 7, 7, 8, 8, 10);
        nums.set(5, 11);
        int target = 6;
        System.out.println(new Solution().searchRange(nums, target));
    }
}
