import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param n: An integer.
     * @return: A string list.
     */
    public List<String> printX(int n) {
        // write your code here.
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chs = new char[n];
            Arrays.fill(chs, ' ');
            chs[i] = chs[n - 1 - i] = 'X';
            res.add(new String(chs));
        }
        
        return res;
    }
}
