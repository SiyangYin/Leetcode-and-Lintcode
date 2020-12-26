import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    private int res;
    
    public int maxLength(List<String> arr) {
        List<Integer> bits = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            int bit = 0;
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                
                int tmp = 1 << ch - 'a';
                if ((bit & tmp) != 0) {
                    bit = 0;
                    break;
                } else {
                    bit |= tmp;
                }
            }
            if (bit != 0) {
                bits.add(bit);
            }
        }
        
        dfs(0, 0, bits);
        return res;
    }
    
    private void dfs(int pos, int cur, List<Integer> bits) {
        res = Math.max(res, len(cur));
    
        for (int i = pos; i < bits.size(); i++) {
            if ((cur & bits.get(i)) == 0) {
                dfs(i + 1, cur | bits.get(i), bits);
            }
        }
    }
    
    private int len(int cur) {
        int res = 0;
        while (cur > 0) {
            res += cur & 1;
            cur >>= 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxLength(Arrays.asList("cha", "r", "act", "ers")));
    }
}
