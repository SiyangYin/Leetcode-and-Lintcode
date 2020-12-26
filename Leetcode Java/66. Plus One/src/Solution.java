import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            list.add(digits[i]);
        }
        
        int carry = 1;
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            cur += carry;
            carry = cur / 10;
            list.set(i, cur % 10);
        }
        
        if (carry == 1) {
            list.add(1);
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(list.size() - 1 - i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{0})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{1,2,9})));
    }
}