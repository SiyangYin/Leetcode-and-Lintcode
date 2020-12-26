import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int maximumSwap(int num) {
        List<Integer> digits = new ArrayList<>();
        int n = num;
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
    
        Collections.reverse(digits);
        List<Integer> copy = new ArrayList<>(digits);
        digits.sort((x, y) -> -Integer.compare(x, y));
    
        int swap = -1, j = -1;
        for (int i = 0; i < digits.size(); i++) {
            if (digits.get(i) != copy.get(i)) {
                j = i;
                swap = digits.get(i);
                break;
            }
        }
        
        if (j == -1) {
            return num;
        }
    
        for (int i = copy.size() - 1; i >= 0; i--) {
            if (copy.get(i) == swap) {
                Collections.swap(copy, i, j);
            }
        }
        
        int res = 0;
        for (int i = 0; i < copy.size(); i++) {
            res *= 10;
            res += copy.get(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(2736));
        System.out.println(new Solution().maximumSwap(9973));
    }
}
