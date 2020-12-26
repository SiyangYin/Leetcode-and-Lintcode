import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 1;
        while (!set.isEmpty()) {
            int curNum = set.iterator().next();
            int curLen = 1;
            set.remove(curNum);
            for (int i = 1; set.remove(curNum + i); i++) {
                curLen++;
            }
            for (int i = 1; set.remove(curNum - i); i++) {
                curLen++;
            }
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }
        return maxLen;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
