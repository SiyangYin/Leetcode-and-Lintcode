import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        
        long lower = 1L, upper = 1L << 32;
        while (lower < label) {
            lower <<= 1;
        }
        if (lower > label) {
            lower >>= 1;
        }
        
        while (upper > label) {
            upper >>= 1;
        }
        upper = upper * 2 - 1;
        
        res.add(label);
        while (label > 1) {
            lower >>= 1;
            upper >>= 1;
            label = (int) (lower + upper - label / 2);
            res.add(label);
        }
        
        Collections.reverse(res);
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().pathInZigZagTree(14));
        System.out.println(new Solution().pathInZigZagTree(16));
    }
}
