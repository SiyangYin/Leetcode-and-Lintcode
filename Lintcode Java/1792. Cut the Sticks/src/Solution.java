import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param sticks: the length of each stick
     * @return: return a Integer array
     */
    public int[] CutTheSticks(int[] sticks) {
        // write your code here
        Arrays.sort(sticks);
        
        List<Integer> list = new ArrayList<>();
        int idx = 0, len = 0;
        while (idx < sticks.length) {
            list.add(sticks.length - idx);
            len = sticks[idx];
            
            int l = idx + 1, r = sticks.length - 1;
            while (l < r) {
                int m = l + (r - l >> 1);
                if (sticks[m] > len) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            
            if (l >= sticks.length || sticks[l] <= len) {
                break;
            }
            
            idx = l;
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().CutTheSticks(new int[]{1, 2, 3, 4, 3, 3, 2, 1})));
    }
}
