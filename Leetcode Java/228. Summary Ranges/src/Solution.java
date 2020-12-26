import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int j = 0, i = 0; i < nums.length;) {
            j = i + 1;
            if (j == nums.length || nums[j - 1] + 1 != nums[j]) {
                res.add(String.valueOf(nums[i]));
                i = j;
                continue;
            }
            
            while (j < nums.length && nums[j - 1] + 1 == nums[j]) {
                j++;
            }
            
            res.add(nums[i] + "->" + nums[j - 1]);
            i = j;
        }
        
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(new Solution().summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}
