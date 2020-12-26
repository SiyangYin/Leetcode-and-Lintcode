import java.util.Arrays;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur ^= nums[i];
        }
        
        int n1 = cur, n2 = cur;
        int lowb = lowbit(cur);
        for (int i = 0; i < nums.length; i++) {
            if ((lowb & nums[i]) == 0) {
                n1 ^= nums[i];
            } else {
                n2 ^= nums[i];
            }
        }
        
        return new int[]{n1, n2};
    }
    
    private int lowbit(int x) {
        return x & -x;
    }
    
    private void printBit(int x) {
        StringBuilder sb = new StringBuilder();
        while (x != 0) {
            sb.append(x & 1);
            x >>= 1;
        }
        System.out.print(sb.reverse() + " ");
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
