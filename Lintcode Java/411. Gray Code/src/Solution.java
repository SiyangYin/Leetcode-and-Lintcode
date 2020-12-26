import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: a number
     * @return: Gray code
     */
    public List<Integer> grayCode(int n) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        res.add(0);
    
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) + (1 << i));
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().grayCode(2));
    }
}
