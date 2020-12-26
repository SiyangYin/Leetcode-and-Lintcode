import java.util.Arrays;

public class Solution {
    /**
     * @param g: children's greed factor
     * @param s: cookie's size
     * @return: the maximum number
     */
    public int findContentChildren(int[] g, int[] s) {
        // Write your code here
        Arrays.sort(g);
        Arrays.sort(s);
        
        int res = 0, i = 0, j = 0;
        while (i < g.length && j < s.length) {
            while (j < s.length && s[j] < g[i]) {
                j++;
            }
            
            if (j == s.length) {
                break;
            }
            
            res++;
            i++;
            j++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findContentChildren(new int[]{1, 2}, new int[]{1, 2,3}));
    }
}
