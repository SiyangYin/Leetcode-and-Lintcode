import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int t = 0;
        int i = A.length - 1;
        List<Integer> res = new ArrayList<>();
        
        while (i >= 0 || K != 0) {
            if (i >= 0) {
                t += A[i];
            }
            if (K != 0) {
                t += K % 10;
            }
            K /= 10;
            i--;
            res.add(t % 10);
            t /= 10;
        }
        
        if (t == 1) {
            res.add(1);
        }
    
        Collections.reverse(res);
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {2, 1, 5};
        int K = 806;
        System.out.println(new Solution().addToArrayForm(A, K));
    }
}
