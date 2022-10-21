import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int i : nums) {
            int cnt = 1;
            set.remove(i);
            int j = i - 1;
            while (set.contains(j)) {
                cnt++;
                set.remove(j);
                j--;
            }
            j = i + 1;
            while (set.contains(j)) {
                cnt++;
                set.remove(j);
                j++;
            }
            if (cnt > max) {
                max = cnt;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution1().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
