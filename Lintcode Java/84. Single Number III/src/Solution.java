import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer array
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        int axorb = 0;
        for (int i : A) {
            axorb ^= i;
        }
        
        int lowb = lowbit(axorb);
        int a = 0, b = 0;
        for (int i : A) {
            if ((i & lowb) != 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        
        return Arrays.asList(a, b);
    }
    
    private int lowbit(int x) {
        return x & (-x);
    }
}