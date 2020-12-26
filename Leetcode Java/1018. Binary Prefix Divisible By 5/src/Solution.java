import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            cur = ((cur << 1) + A[i]) % 5;
            res.add(cur == 0);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().prefixesDivBy5(new int[]{0, 1, 1}));
    }
}
