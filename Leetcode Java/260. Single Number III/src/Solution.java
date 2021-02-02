import java.util.Arrays;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int cur = 0;
        for (int num : nums) {
            cur ^= num;
        }
        
        int n1 = cur, n2 = cur;
        int lowb = lowbit(cur);
        for (int num : nums) {
            if ((lowb & num) == 0) {
                n1 ^= num;
            } else {
                n2 ^= num;
            }
        }
        
        return new int[]{n1, n2};
    }
    
    private int lowbit(int x) {
        return x & -x;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
