import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        for (int n : num) {
            set.add(n);
        }
        
        int res = 0;
        while (!set.isEmpty()) {
            int cur = set.iterator().next();
            set.remove(cur);
            int len = 1, i = 1;
            while (set.contains(cur + i)) {
                set.remove(cur + i);
                i++;
                len++;
            }
            
            i = 1;
            while (set.contains(cur - i)) {
                set.remove(cur - i);
                i++;
                len++;
            }
            
            res = Math.max(res, len);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
