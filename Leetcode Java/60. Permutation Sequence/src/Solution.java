import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        StringBuilder sb = new StringBuilder();
        k -= 1;
        
        List<Integer> rest = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            rest.add(i);
        }
        
        for (int i = n; i >= 1; i--) {
            int remain = k % fact[i - 1];
            int a = k / fact[i - 1];
            k = remain;
            sb.append(rest.get(a));
            
            rest.remove(a);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(4, 9));
    }
}
