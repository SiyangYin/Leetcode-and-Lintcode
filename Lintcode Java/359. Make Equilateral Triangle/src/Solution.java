import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param lengths: the lengths of sticks at the beginning.
     * @return: return the minimum number of cuts.
     */
    public int makeEquilateralTriangle(int[] lengths) {
        // write your code here.
        Arrays.sort(lengths);
        Set<Integer> set = new HashSet<>();
        int res = 2;
        for (int i = 0; i < lengths.length; i++) {
            int j = i;
            while (j < lengths.length && lengths[j] == lengths[i]) {
                j++;
            }
            
            if (j - i >= 3) {
                return 0;
            } else if (j - i == 2 && j < lengths.length) {
                res = 1;
            }
            
            if (lengths[i] % 2 == 0 && set.contains(lengths[i] / 2)) {
                res = 1;
            }
            
            set.add(lengths[i]);
            
            i = j - 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().makeEquilateralTriangle(new int[]{2, 3, 7, 5}));
    }
}
