import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: n
     * @param k: the k th permutation
     * @return: return the k-th permutation
     */
    public String getPermutation(int n, int k) {
        // write your code here
        int[] fac = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        StringBuilder sb = new StringBuilder();
        
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int a = k / fac[i];
            sb.append(list.get(a));
            list.remove(a);
        
            k = k % fac[i];
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3, 4));
    }
}
